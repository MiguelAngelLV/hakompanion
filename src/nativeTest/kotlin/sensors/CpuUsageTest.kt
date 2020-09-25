package sensors

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import platform.posix.sleep
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class CpuUsageTest {



    @Test
    fun `Get CPU usage`() {

        val cpuUsa = CpuUsage()

        sleep(1)
        val value = cpuUsa.getValue()

        assertTrue(value.isNotBlank())

        println(value)

    }

    @Test
    fun `Get config`() {

        val cpuUsage = CpuUsage()
        val config = Json.encodeToString(cpuUsage.discoveryConfig)

        assertTrue(config.contains("mdi:cpu-64-bit"))
        assertFalse(config.contains("null"))


    }


}
