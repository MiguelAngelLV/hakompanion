package sensors

import config.Config
import discovery.DiscoveryConfig
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import models.Sensor
import utils.process.Process

class Battery(config: Config) : Sensor(config) {


    override val id: String = "battery"
    override val names = read().map { it.name }

    override fun getValue(): String {

        val map = read().associateBy { it.name }

        return Json.encodeToString(map)
    }


    override fun createDefaultConfig(name: String): DiscoveryConfig {
        val c = super.createDefaultConfig(name)
        c.unitOfMeasurement = "%"
        c.icon = "mdi:battery"
        c.jsonAttributesTopic = c.stateTopic
        c.jsonAttributesTemplate = "{{ value_json['$name'] | tojson }}"
        c.valueTemplate = "{{ value_json['$name']['percentage'] }}"
        return c
    }

    fun read(): List<BatteryStatus> {
        val data = Process.execute("upower --dump")

        return data
            .split("\n\n")
            .mapNotNull { createDevice(it) }
    }


    private fun createDevice(definition: String): BatteryStatus? {
        val data = definition.split("\n")
            .map { it.trim() }
            .filter { it.contains(":") }
            .associateBy({ it.substringBefore(":") }, { it.substringAfter(":").trim() })

        if (!data.containsKey("model"))
            return null

        return BatteryStatus(
            name = if (data.containsKey("vendor")) "${data["vendor"]} ${data["model"]}" else "${data["model"]}",
            percentage = "${data["percentage"]}".substringBefore("%").toIntOrNull() ?: 0,
            state = "${data["state"]}"
        )


    }



    @Serializable
    class BatteryStatus(val name: String, val percentage: Int, val state: String)
}
