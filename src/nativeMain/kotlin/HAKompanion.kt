import config.Config
import kotlinx.coroutines.delay
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonDecoder
import models.BinarySensor
import models.Entity
import models.Sensor
import mqtt.PahoMqttClient
import platform.posix.sleep
import sensors.CpuUsage
import sensors.RamUsage
import sensors.Webcam

class HAKompanion(val config: Config) {


    var connected = false
    val mqttClient = PahoMqttClient()
    val sensors = ArrayList<Sensor>()
    val binarySensor = ArrayList<BinarySensor>()


    init {
        connect()
        createDevices()
    }


    fun connect() {
        connected = mqttClient.connect(config.mqtt.host, config.mqtt.username, config.mqtt.password)
    }


    fun createDevices() {
        sensors.add(RamUsage(config))
        sensors.add(CpuUsage(config))
        binarySensor.add(Webcam(config))

    }


    fun sendConfigs() {

        if (!connected)
            return

        sensors.forEach {
            mqttClient.publish(it.discoveryTopic, Json.encodeToString(it.discoveryConfig), true)
        }

        binarySensor.forEach {
            mqttClient.publish(it.discoveryTopic, Json.encodeToString(it.discoveryConfig), true)
        }

    }

    fun sendData() {

        if (!connected)
            return

        sensors.forEach {
            mqttClient.publish(it.stateTopic, it.getValue())
        }

        binarySensor.forEach {
            mqttClient.publish(it.stateTopic, it.getValue())
        }

    }



}
