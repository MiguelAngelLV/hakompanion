package config

import kotlinx.serialization.Serializable

@Serializable
class MqttConfig {

    var host: String = ""
    var username: String? = null
    var password: String? = null


}
