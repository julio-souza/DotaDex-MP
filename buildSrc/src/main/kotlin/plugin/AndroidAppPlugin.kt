/*
 *  Created by Júlio Souza on 26/02/2021
 *  Copyright (c) 2021.
 *  Moda44 all rights reserved.
 *  Last modified 26/02/21 14:26
 */

package plugin


import org.gradle.api.Plugin
import org.gradle.api.Project
import plugin.extension.androidConfiguration
import plugin.extension.configureKotlinJvm
import plugin.extension.getAndroidAppExtensionForConfiguration

class AndroidAppPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.run {
            println("Applying AndroidAppPlugin to the project: $name")

            plugins.apply(dependency.Plugin.androidApplication)
            plugins.apply(dependency.Plugin.kotlinAndroid)


            getAndroidAppExtensionForConfiguration(androidConfiguration)
            configureKotlinJvm()
        }
    }
}
