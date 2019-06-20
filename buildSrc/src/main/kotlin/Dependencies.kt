object Versions {
    // Android SDK
    const val compileSDK = 28
    const val buildTools = "28.0.3"
    const val minSDK = 21
    const val targetSDK = 28
    const val androidGradle = "3.5.0-beta04"

    // kotlin
    const val kotlinVersion = "1.3.40"

    // Google libraries
    const val appCompat = "1.0.2"
    const val constraintLayout = "1.1.3"
    const val lifecycle = "2.0.0"
    const val coreKTX = "1.0.2"
}

@Suppress("Reformat")
object Deps {
    object GradlePlugin {
        val androidGradle = "com.android.tools.build:gradle:${Versions.androidGradle}"
        val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    }

    object Kotlin {
        const val stdlibJdk = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
    }

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val coreKTX = "androidx.core:core-ktx:${Versions.coreKTX}"
    }
}