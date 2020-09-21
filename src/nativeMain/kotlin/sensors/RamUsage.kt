package sensors

import models.Sensor
import utils.process.Process

class RamUsage : Sensor() {


    override fun getValue(): String {

        val regex = Regex("(\\w+):\\s+(\\d+)")

        val process = Process.execute("cat /proc/meminfo")
            .split("\n")
            .mapNotNull { regex.find(it) }
            .associateBy( { it.groupValues[1] }, { it.groupValues[2].toLong() })

        val total = process["MemTotal"] ?: 0L
        val available = process["MemAvailable"] ?: 0L

        val usage = total - available

        return """{ "state": ${usage / 1024 } }"""
    }

}
