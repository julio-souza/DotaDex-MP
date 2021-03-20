/*
 *  Created by Júlio Souza on 26/02/2021
 *  Copyright (c) 2021.
 *  Moda44 all rights reserved.
 *  Last modified 26/02/21 14:09
 */

package plugin.extension


import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

private const val JAVA_PLUGIN_EXTENSION = "java"

fun Project.configureKotlinJvm() =
    this.tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            useIR = true
        }
    }

fun Project.configureJava() =
    getJavaExtensionForConfiguration {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

private fun Project.getJavaExtensionForConfiguration(configuration: JavaPluginExtension.() -> Unit) =
    configuration(this.extensions.findByName(JAVA_PLUGIN_EXTENSION) as JavaPluginExtension)
