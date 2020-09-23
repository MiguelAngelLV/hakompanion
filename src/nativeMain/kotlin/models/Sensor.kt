package models

abstract class Sensor : Entity() {


    abstract fun getValue(): String

}
