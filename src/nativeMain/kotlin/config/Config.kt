package config

import kotlinx.serialization.Serializable

@Serializable
class Config {

    var mqtt =  MqttConfig()
    var device = Device()
    var discovery: String = ""

}
