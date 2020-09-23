package mqtt

import kotlinx.coroutines.flow.Flow

interface MqttClient {

  val messages: Flow<MqttMessage>

  fun connect(serverUri: String, username: String?, password: String?): Boolean

  fun disconnect()

  fun publish(topic: String, payload: String, retain: Boolean = false, qos: QoS = QoS0)

  fun subscribe(topic: String, qos: QoS = QoS0)

  fun unsubscribe(topic: String)

}
