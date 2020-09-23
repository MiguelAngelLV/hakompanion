package utils.files

import kotlinx.cinterop.*
import platform.posix.*


class File(path: String, mode: String) {

    var file = fopen(path, mode)



    val isOpen = file != null


    fun close() {
        fclose(file)
    }

    fun readString(): String? = memScoped {

        if (!isOpen) return null

        val size = 1024
        val buffer = allocArray<ByteVar>(size)

        return buildString {
            var read = fgets(buffer, size, file)?.toKString()
            while (read != null) {
                append(read)
                read = fgets(buffer, size, file)?.toKString()
            }
        }
    }


}
