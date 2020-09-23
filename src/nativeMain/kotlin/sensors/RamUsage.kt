package sensors

import discovery.Config
import discovery.Device
import models.Sensor
import utils.process.Process

class RamUsage : Sensor() {


    override val id: String = "ram_usage"
    override val name: String = "Ram Usage"
    override val subType: String = "ram_usage"


    override val config: Config by lazy {
        val config = super.config
        config.icon = "mdi:memory"
        config.unitOfMeasurement = "MB"
        config
    }


    override fun getValue(): String {

        val regex = Regex("(\\w+):\\s+(\\d+)")

        val process = Process.execute("cat /proc/meminfo")
            .split("\n")
            .mapNotNull { regex.find(it) }
            .associateBy({ it.groupValues[1] }, { it.groupValues[2].toLong() })

        val total = process["MemTotal"] ?: 0L
        val available = process["MemAvailable"] ?: 0L

        val usage = total - available

        return "${usage / 1024}"
    }

}
