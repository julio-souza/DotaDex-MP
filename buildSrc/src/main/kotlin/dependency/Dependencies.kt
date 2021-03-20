package dependency

import dependency.Versions.gradleAndroid
import dependency.Versions.gradleKotlinPlugin

object Versions {
    const val gradleAndroid = "7.0.0-alpha10"
    const val gradleKotlinPlugin = "1.4.31"

    const val compose = "1.0.0-beta02"
}

object Gradle {
    const val android = "com.android.tools.build:gradle:$gradleAndroid"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$gradleKotlinPlugin"
}

object Compose {
    const val activity = "androidx.activity:activity-compose:1.3.0-alpha04"
    const val material = "androidx.compose.material:material:${Versions.compose}"
    const val ui = "androidx.compose.ui:ui:${Versions.compose}"
    const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"

    const val uiTest = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
}

object Plugin {
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val kotlin = "kotlin"
    const val kotlinMultiplatform = "org.jetbrains.kotlin.multiplatform"
}

object KotlinPlugin {
    const val multiplatform = "multiplatform"
}
