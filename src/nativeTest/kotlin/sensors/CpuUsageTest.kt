package sensors

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import platform.posix.sleep
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class CpuUsageTest : TestBase() {



    @Test
    fun `Get CPU usage`() {

        val cpuUsa = CpuUsage(config)

        sleep(1)
        val value = cpuUsa.getValue()

        assertTrue(value.isNotBlank())

        println(value)

    }


}
