package models

import config.Config
import config.Device

abstract class BinarySensor(config: Config) : Entity(config) {


    override val type = "binary_sensor"

    abstract fun status() : Boolean

    fun getValue(): String {
        return if (status()) "on" else "off"
    }

}
