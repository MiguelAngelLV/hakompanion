package sensors

import models.BinarySensor
import utils.process.Process

class Webcam : BinarySensor() {


    override fun status(): Boolean {
        val result = Process.execute("lsmod | awk '\$1 ~ /^uvcvideo/'")

        if (result.isEmpty())
            return false

        return result.last() == '1'

    }

}
