import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("org.jlleitschuh.gradle.ktlint")
    id("com.google.gms.google-services")
    `android-application`
}

android {
    defaultConfig {
        applicationId = "jp.sample.ocrsampleandroid"
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            applicationIdSuffix = ".debug"
        }
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), file("proguard-rules.pro"))
        }
    }
}

ktlint {
    version.set("0.31.0")
    android.set(true)
    reporters.set(setOf(ReporterType.CHECKSTYLE))
    ignoreFailures.set(true)
}

val kotlinVersion: String by project

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to arrayOf("*.jar"))))
    implementation(Deps.Kotlin.stdlibJdk)

    implementation(Deps.AndroidX.coreKTX)
    implementation(Deps.AndroidX.appCompat)
    implementation(Deps.AndroidX.constraintLayout)

    implementation("com.google.android.material:material:1.0.0")

    implementation("com.rmtheis:tess-two:9.0.0")
    implementation("androidx.exifinterface:exifinterface:1.0.0")

    testImplementation("junit:junit:4.12")
    androidTestImplementation("com.android.support.test:runner:1.0.2")
    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.2")

    implementation("com.google.firebase:firebase-core:16.0.9")
    implementation("com.google.firebase:firebase-ml-vision:20.0.0")
}