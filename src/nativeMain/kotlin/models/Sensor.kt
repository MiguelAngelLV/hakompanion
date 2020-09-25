package models

import config.Config
import config.Device

abstract class Sensor(config: Config) : Entity(config) {


    override val type: String = "sensor"

    abstract fun getValue(): String

}
