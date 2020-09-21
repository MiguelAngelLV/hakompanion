package models

abstract class BinarySensor : Device() {

    abstract fun status() : Boolean

}
