import kotlinx.cinterop.*
import libpaho.*

fun main() {

    memScoped {
        val client = alloc<MQTTClientVar>()
        val createOptions = MQTTClient_createOptions_init().copy {
            MQTTVersion = MQTTVERSION_5
        }

        val rc = MQTTClient_createWithOptions(client.ptr, "tcp://10.0.0.3:1883", "Kompanion",
                MQTTCLIENT_PERSISTENCE_NONE, null, createOptions.ptr)

        println("Create reason code: $rc")

        val connectOptions = MQTTClient_connectOptions_init().copy {
            keepAliveInterval = 10
            cleanstart = 1
            username = "username".cstr.ptr
            password = "password".cstr.ptr
        }

        val props = MQTTProperties_init()
        val willProps = MQTTProperties_init()

        val response = MQTTClient_connect5(client.value, connectOptions.ptr, props.ptr, willProps.ptr)

        response.useContents {
            println("Connect reason code: $reasonCode")
        }
    }

}
