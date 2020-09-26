package sensors

import config.Config
import discovery.DiscoveryConfig
import models.Sensor
import utils.process.Process

class CpuUsage(config: Config) : Sensor(config) {


    var lasts = reads()

    override val id: String = "cpu_usage"
    override val names: List<String> = listOf("cpu")

    override fun createDefaultConfig(name: String): DiscoveryConfig {
        val c = super.createDefaultConfig(name)
        c.icon = "mdi:cpu-64-bit"
        c.name = "${name.toUpperCase()} Usage"
        c.jsonAttributesTopic = c.stateTopic
        c.valueTemplate = "{{ value_json.cpu }}"
        c.unitOfMeasurement = "%"
        return c
    }



    override fun getValue(): String {
        val news = reads()
        val diff = lasts.mapIndexed { index: Int, l: CPUData ->
            val n = news[index]
            CPUData(n.cpu, n.use - l.use, n.idle - l.idle)
        }

        lasts = news

        val state = diff.joinToString {  """ "${it.cpu}": ${((10000 * it.use) / (it.use + it.idle))/100f} """ }

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


    data class CPUData(var cpu: String, val use: Long, val idle: Long)
}
