import kotlinx.coroutines.runBlocking
import mqtt.PahoMqttClient
import platform.posix.sleep

fun main(): Unit = runBlocking {
  Platform.isMemoryLeakCheckerActive = false

  val client = PahoMqttClient()
  val result = client.connect("ip:port", "", "")
  println(result)

  client.subscribe("a_topic")
  sleep(5)
}
