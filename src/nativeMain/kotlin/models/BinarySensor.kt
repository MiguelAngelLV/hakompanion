package models

abstract class BinarySensor : Entity() {


    override val type = "binary_sensor"

    abstract fun status() : Boolean

}
