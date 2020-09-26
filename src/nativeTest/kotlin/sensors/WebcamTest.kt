package sensors

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class WebcamTest : TestBase(){


    @Test
    fun `Check off`() {
        val webcam = Webcam(config)


        assertTrue(webcam.hasWebcam())
        assertFalse(webcam.status())


    }


}
