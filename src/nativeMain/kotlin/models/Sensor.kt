package models

abstract class Sensor : Device() {


    abstract fun getValue(): String

}
