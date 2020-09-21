import sensors.RamUsage
import sensors.Webcam

fun main() {

    val sensor = Webcam()

    if (sensor.status())
        println("ON")
    else
        println("OFF")



}
