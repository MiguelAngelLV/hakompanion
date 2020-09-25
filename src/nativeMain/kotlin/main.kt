import config.Config
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import mqtt.PahoMqttClient
import platform.posix.exit
import utils.files.File
import kotlin.time.Duration
import kotlin.time.DurationUnit

fun main(args: Array<String>): Unit = runBlocking(Dispatchers.Default) {


  Platform.isMemoryLeakCheckerActive = false

  if (args.isEmpty()) {
    println("You need set a config file")
    exit(1)
  }

  val path = args.first()

  val file = File(path, "r")

  if (!file.isOpen) {
    println("Invalid config file")
    exit(1)
  }

  val json = file.readString()

  if (json == null) {
    println("Invalid config file")
    exit(1)
    return@runBlocking
  }

  val config = Json.decodeFromString<Config>(json)


  val haKompanion = HAKompanion(config)

  if (!haKompanion.connected) {
    println("Fail to connect to ${config.mqtt.host}")
    exit(1)
  }

  haKompanion.sendConfigs()
  println("Connected to ${config.mqtt.host}")

  while(haKompanion.connected) {
    haKompanion.sendData()
    delay(1000*60L)
  }

}
