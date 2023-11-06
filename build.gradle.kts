buildscript {
    dependencies {
        classpath("com.google.gms:google-services:4.4.0")
    }
}

plugins {
    id("com.android.application") version "8.0.2" apply false
    id("com.android.library") version "8.0.2" apply false
    //https://kotlinlang.org/docs/releases.html#update-to-a-new-release
    id("org.jetbrains.kotlin.android") version "1.8.20" apply false
}