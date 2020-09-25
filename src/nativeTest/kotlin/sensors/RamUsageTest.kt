package sensors

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class RamUsageTest {



    @Test
    fun `Get RAM usage`() {

        val ramUsage = RamUsage()

        val value = ramUsage.getValue()

        assertTrue(value.isNotBlank())

    }

    @Test
    fun `Get config`() {

        val ramUsage = RamUsage()
        val config = Json.encodeToString(ramUsage.discoveryConfig)

        assertTrue(config.contains("mdi:memory"))
        assertFalse(config.contains("null"))


    }


}
