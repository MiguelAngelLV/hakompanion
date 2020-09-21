package sensors

import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.fail


class RamUsageTest {



    @Test
    fun `Get RAM usage`() {

        val ramUsage = RamUsage()

        val value = ramUsage.getValue()

        assertTrue(value.isNotBlank())

    }


}
