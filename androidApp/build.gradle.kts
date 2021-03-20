plugins {
    AndroidAppPlugin
}

android {
    defaultConfig {
        applicationId = configuration.AppConfig.applicationId
    }
}

dependencies {
    implementation(project(module.Shared.data))
    implementation(project(module.Shared.domain))
    implementation(project(module.Shared.local))
    implementation(project(module.Shared.network))

    implementation(dependency.Compose.ui)
    implementation(dependency.Compose.material)
    implementation(dependency.Compose.uiTooling)
    implementation(dependency.Compose.activity)

    androidTestImplementation(dependency.Compose.uiTest)
}
