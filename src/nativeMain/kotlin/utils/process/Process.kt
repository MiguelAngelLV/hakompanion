package utils.process

import kotlinx.cinterop.CPointer
import kotlinx.cinterop.refTo
import kotlinx.cinterop.toKString
import platform.posix.*

object Process {

    fun execute(command: String) : String {
        val fp: CPointer<FILE>? = popen(command, "r")
        val buffer = ByteArray(4096)
        val returnString = StringBuilder()

        if (fp == NULL) {
            printf("Failed to run command\n" )
            exit(1)
        }

        var scan = fgets(buffer.refTo(0), buffer.size, fp)
        if(scan != null) {
            while (scan != null) {
                returnString.append(scan.toKString())
                scan = fgets(buffer.refTo(0), buffer.size, fp)
            }
        }

        pclose(fp)
        return returnString.trim().toString()
    }


}
