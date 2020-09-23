package models

abstract class BinarySensor : Entity() {

    abstract fun status() : Boolean

}
