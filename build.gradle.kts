plugins {
    kotlin("multiplatform") version "1.4.10"
    kotlin("plugin.serialization") version "1.4.10"
}
group = "org.malv"
version = "0.1"

repositories {
    mavenCentral()

    maven( url = "https://repo.binom.pw/releases")



}
kotlin {
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    nativeTarget.apply {
        binaries {
            executable {
                entryPoint = "main"
            }
        }

        val main by compilations.getting
        val libpaho by main.cinterops.creating
    }
    sourceSets {
        val nativeMain by getting
        val nativeTest by getting
    }


}

dependencies {
    commonMainApi("pw.binom.io:core:0.1.18")
    commonMainImplementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.0-RC2")
}

