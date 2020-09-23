package sensors

import discovery.Config
import discovery.Device
import models.BinarySensor
import utils.process.Process


class Webcam : BinarySensor() {

    override val id: String = "webcam"
    override val name: String = "Web Cam"
    override val subType: String = "webcam"


    override val config: Config by lazy {
        config.icon = "mdi:webcam"
        config
    }


    fun hasWebcam(): Boolean {
        val result = Process.execute("lsmod | awk '\$1 ~ /^uvcvideo/'")
        return result.isNotBlank()
    }


    override fun status(): Boolean {
        val result = Process.execute("lsmod | awk '\$1 ~ /^uvcvideo/'")

        if (result.isEmpty())
            return false

        return result.last() == '1'

    }

}
