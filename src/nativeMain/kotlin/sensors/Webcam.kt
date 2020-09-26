package sensors

import config.Config
import config.Device
import discovery.DiscoveryConfig
import models.BinarySensor
import utils.process.Process


class Webcam(config: Config) : BinarySensor(config) {

    override val id: String = "webcam"

    override val names = listOf("Webcam")


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
