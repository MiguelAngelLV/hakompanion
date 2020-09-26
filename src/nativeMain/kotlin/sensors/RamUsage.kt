package sensors

import config.Config
import discovery.DiscoveryConfig
import models.Sensor
import utils.process.Process

class RamUsage(config: Config) : Sensor(config) {


    override val id: String = "ram_usage"
    override val names = listOf("Ram Usage")



    override fun createDefaultConfig(name: String): DiscoveryConfig {
        val c = super.createDefaultConfig(name)
        c.icon = "mdi:memory"
        c.unitOfMeasurement = "MB"
        return c;
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
