package config

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Device(

    @SerialName("identifiers")
    var identifiers: List<String> = emptyList(),

    @SerialName("manufacturer")
    var manufacturer: String? = null,

    @SerialName("model")
    var model: String? = null,

    @SerialName("name")
    var name: String? = null,

    @SerialName("sw_version")
    var swVersion: String? = null
)

