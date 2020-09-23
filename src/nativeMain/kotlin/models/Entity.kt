package models

import discovery.Config
import discovery.Device

abstract class Entity  {


    abstract val id: String
    abstract val type: String
    abstract val name: String
    abstract val subType: String

    open val config: Config by lazy {
        Config(
            uniqueId = id,
            stateTopic = "hacompanion/$type/$subType/$id/state",
            device = listOf(Device(name = "Computer", identifiers = listOf("HA Companion")))
        )

    }



}
