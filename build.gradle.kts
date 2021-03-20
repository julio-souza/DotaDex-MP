buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(dependency.Gradle.kotlin)
        classpath(dependency.Gradle.android)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}

plugins {
    id("script.quality")
}
