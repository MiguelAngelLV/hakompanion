package models

import config.Config
import discovery.DiscoveryConfig

abstract class Entity(val config: Config) {


    abstract val id: String
    abstract val type: String
    abstract val name: String
    abstract val subType: String

    open val discoveryConfig: DiscoveryConfig by lazy {
        DiscoveryConfig(
            name = name,
            device = config.device,
            uniqueId = uniqueId,
            stateTopic = stateTopic
        )

    }


    val uniqueId: String
        get() = "${config.device.identifiers.first()}_$id"

    val stateTopic: String
        get() = "${config.device.identifiers.first()}/$type/$subType/$id/state"

    val discoveryTopic: String
        get() = "${config.discovery}/$type/$uniqueId/$subType/config"


}
