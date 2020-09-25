package mqtt

import kotlinx.cinterop.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import libpaho.*
import kotlin.native.concurrent.ThreadLocal

private val DEBUG = false

@ThreadLocal
private object Current {
  var reference: PahoMqttClient? = null
}

@Suppress("EXPERIMENTAL_UNSIGNED_LITERALS", "EXPERIMENTAL_API_USAGE")
class PahoMqttClient : MqttClient {

  private var client: MQTTClientVar? = null

  internal val messagesChannel = Channel<MqttMessage>(Channel.UNLIMITED)
  override val messages = messagesChannel.receiveAsFlow()

  override fun connect(serverUri: String, username: String?, password: String?): Boolean {
    val client = nativeHeap.alloc<MQTTClientVar>()

    memScoped {
      val createOptions = MQTTClient_createOptions_init().copy {
        MQTTVersion = MQTTVERSION_5
      }

      val createResult = MQTTClient_createWithOptions(client.ptr, serverUri, "Kompanion",
        MQTTCLIENT_PERSISTENCE_NONE, null, createOptions.ptr)

      if (createResult != 0) {
        println("Create failed with result code: $createResult")
        nativeHeap.free(client)
        return false
      }

      val connectOptions = MQTTClient_connectOptions_init().copy {
        keepAliveInterval = 10
        username?.let { this.username = it.cstr.ptr }
        password?.let { this.password = it.cstr.ptr }
      }

      val props = MQTTProperties_init()
      val willProps = MQTTProperties_init()

      val callbacksResult = MQTTClient_setCallbacks(client.value, null,
        staticCFunction(::onDisconnected),
        staticCFunction(::onMessageArrived),
        staticCFunction(::onDeliveryComplete)
      )

      if (callbacksResult != MQTTCLIENT_SUCCESS) {
        println("Callbacks setup failed")
        nativeHeap.free(client)
        return false
      }

      val connectResult = MQTTClient_connect5(client.value, connectOptions.ptr, props.ptr, willProps.ptr)
      val connectResultCode = connectResult.useContents { reasonCode }

      if (connectResultCode != 0U) {
        println("Connect failed with result code: $connectResultCode")
        nativeHeap.free(client)
        return false
      }

    }

    this.client = client
    Current.reference = this
    return true
  }

  override fun disconnect() {
    val client = client ?: return
    MQTTClient_disconnect5(client.value, 1000, 0, null)
    MQTTClient_destroy(client.ptr)
    this.client = null
    Current.reference = null
  }

  override fun publish(topic: String, payload: String, retain: Boolean, qos: QoS) {
    val client = client ?: return

    val result = MQTTClient_publish5(client.value, topic, payload.length, payload.cstr,
      qos.value, if (retain) 1 else 0, null, null)

    if (DEBUG) {
      println("Publish result: ${result.useContents { reasonCode }}")
    }
  }

  override fun subscribe(topic: String, qos: QoS) {
    val client = client ?: return

    val result = MQTTClient_subscribe5(client.value, topic, qos.value, null, null)
    if (DEBUG) {
      println("Subscribe result: ${result.useContents { reasonCode }}")
    }
  }

  override fun unsubscribe(topic: String) {
    val client = client ?: return

    val result = MQTTClient_unsubscribe5(client.value, topic, null)
    if (DEBUG) {
      println("Unsubscribe result: ${result.useContents { reasonCode }}")
    }
  }

}


@Suppress("UNUSED_PARAMETER")
private fun onDisconnected(
  context: COpaquePointer?,
  cause: CPointer<ByteVar>?
) {
  initRuntimeIfNeeded()
  println("Client disconnected")
}

@Suppress("UNUSED_PARAMETER")
private fun onMessageArrived(
  context: COpaquePointer?,
  topicPtr: CPointer<ByteVar>?,
  topicLength: Int,
  messagePtr: CPointer<MQTTClient_message>?
): Int {
  initRuntimeIfNeeded()
  val topic = if (topicLength == 0) {
    topicPtr?.toKString()
  } else {
    topicPtr?.toKString(topicLength)
  } ?: return 0

  val msgVal = messagePtr!!.pointed
  val message = msgVal.payload!!.reinterpret<ByteVar>().toKString(msgVal.payloadlen)

  if (DEBUG) {
    println("Received on topic $topic msg with data: $message")
  }

  GlobalScope.launch(Dispatchers.Default) {
    Current.reference?.messagesChannel?.offer(MqttMessage(topic, message))
  }
  return 1
}

@Suppress("UNUSED_PARAMETER")
private fun onDeliveryComplete(
  context: COpaquePointer?,
  token: MQTTClient_deliveryToken
) {
  initRuntimeIfNeeded()
}

fun CPointer<ByteVar>.toKString(length: Int): String {
  val bytes = this.readBytes(length)
  return bytes.decodeToString()
}
