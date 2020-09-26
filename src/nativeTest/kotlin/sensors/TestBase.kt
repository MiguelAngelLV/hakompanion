package sensors

import config.Config

open class TestBase {


    val config = Config()

    init {
        config.device.apply {
            name = "Test"
            identifiers = listOf("Testing")
        }

    }




}
