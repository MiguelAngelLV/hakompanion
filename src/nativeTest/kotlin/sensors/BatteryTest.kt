package sensors

import kotlin.test.Test

class BatteryTest : TestBase() {


    @Test
    fun `Battery read`() {

        val battery = Battery(config)

        println(battery.read())
    }


}
