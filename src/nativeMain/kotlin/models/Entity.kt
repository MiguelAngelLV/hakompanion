package models

import config.Config
import discovery.DiscoveryConfig

abstract class Entity(val config: Config) {


    abstract val id: String
    abstract val type: String
    abstract val names: List<String>


    fun getConfigs() : Map<String, DiscoveryConfig> {
        return names.associateBy({ createDiscoveryTopic(it) }, { createDefaultConfig(it) })
    }

    open fun createDefaultConfig(name: String): DiscoveryConfig {
        return DiscoveryConfig(
            name = "${config.device.name} $name",
            device = config.device,
            stateTopic = stateTopic,
            uniqueId = createUniqueId(name)
        )
    }


    val deviceId: String
        get() = "${config.device.identifiers.first()}_$id"

    val stateTopic: String
        get() = "${config.device.identifiers.first()}/$type/$id/state"


    private fun createUniqueId(name: String): String {
        return "${deviceId}_${asId(name)}"
    }

    private fun createDiscoveryTopic(name: String): String {
        return "${config.discovery}/$type/$deviceId/${asId(name)}/config"
    }


    private fun asId(name: String): String {
        return name.replace(" ", "_").toLowerCase()
    }

}
