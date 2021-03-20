/*
 *  Created by Júlio Souza on 26/02/2021
 *  Copyright (c) 2021.
 *  Moda44 all rights reserved.
 *  Last modified 22/02/21 19:50
 */

package plugin.extension

import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import configuration.AppConfig
import configuration.DebugConfig
import configuration.ReleaseConfig
import configuration.VersionConfig
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByName
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

private const val ANDROID_EXTENSION = "android"

val androidConfiguration: BaseExtension.(project: Project) -> Unit = { project ->
    compileSdkVersion(AppConfig.compileSdk)
    buildToolsVersion(AppConfig.buildTools)

    defaultConfig {
        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)
        versionCode(VersionConfig.versionCode)
        versionName(VersionConfig.versionName)

        testInstrumentationRunner(AppConfig.testInstrumentationRunner)
    }

    buildTypes {
        getByName(ReleaseConfig.name) {
            minifyEnabled(ReleaseConfig.isMinifyEnabled)
            isTestCoverageEnabled = ReleaseConfig.isTestCoverageEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "${project.rootDir}/proguard-rules.pro"
            )
        }
        getByName(DebugConfig.name) {
            minifyEnabled(DebugConfig.isMinifyEnabled)
            isTestCoverageEnabled = DebugConfig.isTestCoverageEnabled
        }
    }

    buildFeatures.compose = true


    composeOptions {
        kotlinCompilerExtensionVersion = dependency.Versions.compose
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    sourceSets.all {
        java.srcDir("src/$name/kotlin")
    }
}
fun Project.getAndroidAppExtensionForConfiguration(configurations: BaseExtension.(project: Project) -> Unit) =
    (project.extensions.getByName(ANDROID_EXTENSION) as BaseAppModuleExtension).configurations(this)

fun Project.getAndroidLibraryExtensionForConfiguration(configurations: BaseExtension.(project: Project) -> Unit) =
    (project.extensions.getByName(ANDROID_EXTENSION) as LibraryExtension).configurations(this)

