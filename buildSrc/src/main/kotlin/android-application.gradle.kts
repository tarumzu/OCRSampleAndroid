import org.gradle.api.JavaVersion

plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    compileSdkVersion(Versions.compileSDK)
    buildToolsVersion(Versions.buildTools)
    defaultConfig {
        minSdkVersion(Versions.minSDK)
        targetSdkVersion(Versions.targetSDK)
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

kotlin {
    sourceSets.all {
        languageSettings.progressiveMode = true
    }
}