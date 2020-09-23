package sensors

import discovery.Config
import models.Sensor
import utils.process.Process

class CpuUsage : Sensor() {


    override val id: String = "cpu_usage"
    override val name: String = "CPU Usage"
    override val subType: String = "cpu_usage"


    var lasts = reads()


    override val config: Config by lazy {
        val config = this.config
        config.icon = "mdi:cpu-64-bit"
        config.unitOfMeasurement = "%"
        config
    }


    override fun getValue(): String {
        val news = reads()
        val diff = lasts.mapIndexed { index: Int, l: CPUData ->
            val n = news[index]
            CPUData(n.cpu, n.use - l.use, n.idle - l.idle)
        }

        lasts = news

        val state = diff.joinToString { """ "${it.cpu}": ${(100f * it.use) / (it.use + it.idle)} """ }

        return "{ $state }"

    }


    private fun reads(): List<CPUData> {
        return Process.execute("cat /proc/stat")
            .split("\n")
            .filter { it.startsWith("cpu") }
            .map { it.split(Regex("\\s+")) }
            .map {
                CPUData(
                    it[0],
                    it[1].toLong() + it[2].toLong()
                            + it[3].toLong() + it[5].toLong()
                            + it[6].toLong() + it[7].toLong(),
                    it[4].toLong()
                )
            }
    }


    data class CPUData(val cpu: String, val use: Long, val idle: Long)
}
