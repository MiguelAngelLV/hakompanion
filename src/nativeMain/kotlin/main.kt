import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import mqtt.PahoMqttClient

fun main(): Unit = runBlocking(Dispatchers.Default) {
  Platform.isMemoryLeakCheckerActive = false

  val client = PahoMqttClient()
  val result = client.connect("ip", "", "")
  println(result)

  GlobalScope.launch(Dispatchers.Default) {
    client.messages
      .onEach { println("Got message $it") }
      .collect()
  }

  client.subscribe("zigbee2mqtt/#")
  delay(10000)
}
