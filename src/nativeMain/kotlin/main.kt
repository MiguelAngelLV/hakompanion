import kotlinx.cinterop.*
import libpaho.*
import sensors.Webcam

fun main() {

    val sensor = Webcam()

    memScoped {
        val client = alloc<MQTTClientVar>()
        val connectOptions = alloc<MQTTClient_connectOptions>()

        MQTTClient_create(client.ptr, "tcp://10.0.0.3:1883", "Kompanion",
            MQTTCLIENT_PERSISTENCE_NONE, null)

        connectOptions.keepAliveInterval = 20
        connectOptions.cleansession = 1

        val properties = alloc<MQTTProperties>()
        val willProperties = alloc<MQTTProperties>()

        val result = MQTTClient_connect5(client.value, connectOptions.ptr, properties.ptr, willProperties.ptr)
        result.useContents {
            println("Version: $version")
            println("Code: $reasonCode")
            println("Count: $reasonCodeCount")
        }
    }

}
