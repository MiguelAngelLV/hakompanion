package sensors

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class WebcamTest {


    @Test
    fun `Check off`() {
        val webcam = Webcam()


        assertTrue(webcam.hasWebcam())
        assertFalse(webcam.status())


    }


}
