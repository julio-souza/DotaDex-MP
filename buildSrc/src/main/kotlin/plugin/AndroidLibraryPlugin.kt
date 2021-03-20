package plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import plugin.extension.androidConfiguration
import plugin.extension.configureKotlinJvm
import plugin.extension.getAndroidLibraryExtensionForConfiguration

class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.run {
            println("Applying AndroidLibraryPlugin to the project: $name")

            plugins.apply(dependency.Plugin.androidLibrary)
            plugins.apply(dependency.Plugin.kotlinAndroid)

            getAndroidLibraryExtensionForConfiguration(androidConfiguration)
            configureKotlinJvm()
        }
    }
}
