package models

abstract class Sensor : Entity() {


    override val type: String = "sensor"

    abstract fun getValue(): String

}
