package sensors

import config.Config
import config.Device
import models.Sensor

class Battery(config: Config) : Sensor(config){
    override fun getValue(): String {
        TODO("Not yet implemented")
    }

    override val id: String
        get() = TODO("Not yet implemented")
    override val name: String
        get() = TODO("Not yet implemented")
    override val subType: String
        get() = TODO("Not yet implemented")


}
