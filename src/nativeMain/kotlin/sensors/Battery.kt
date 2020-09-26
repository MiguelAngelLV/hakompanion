package sensors

import config.Config
import discovery.DiscoveryConfig
import models.Sensor
import utils.process.Process

class Battery(config: Config) : Sensor(config) {


    override val id: String = "battery"
    override val names = read().keys.toList()

    override fun getValue(): String {
        return "{" + read().entries.joinToString(",") { """ "${it.key}": ${it.value}""" } + "}"
    }


    override fun createDefaultConfig(name: String): DiscoveryConfig {
        val c = super.createDefaultConfig(name)
        c.unitOfMeasurement = "%"
        c.icon = "mdi:battery"
        c.valueTemplate = "{{ value_json['$name'] }}"
        return c
    }

    fun read(): Map<String, String> {
        val data = Process.execute("upower --dump")

        return data
            .split("\n\n")
            .mapNotNull { createDevice(it) }
            .toMap()
    }


    private fun createDevice(definition: String): Pair<String, String>? {
        val data = definition.split("\n")
            .map { it.trim() }
            .filter { it.contains(":") }
            .associateBy({ it.substringBefore(":") }, { it.substringAfter(":").trim() })

        if (!data.containsKey("model"))
            return null

        val name = if (data.containsKey("vendor")) "${data["vendor"]} ${data["model"]}" else "${data["model"]}"
        val value = "${data["percentage"]}".substringBefore("%")

        return name to value
    }

}
