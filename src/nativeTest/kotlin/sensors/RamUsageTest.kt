package sensors

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class RamUsageTest : TestBase(){



    @Test
    fun `Get RAM usage`() {

        val ramUsage = RamUsage(config)

        val value = ramUsage.getValue()

        assertTrue(value.isNotBlank())

    }




}
