package files

import utils.files.File
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class FileTest  {



    @Test
    fun `Read json`() {

        val file = File("src/nativeTest/resources/test.json", "r")
        assertTrue(file.isOpen)

        val json = file.readString()

        assertEquals("{ \"label\":  \"test\"}\n", json)

        

    }


}
