plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
}

/**
 * Keep this versions up to date with the Dependencies file,
 * the build.gradle from buildSrc  can't use the Dependency file.
 */
dependencies {
    compileOnly(gradleApi())

    implementation("com.android.tools.build:gradle:7.0.0-alpha10")

    implementation(kotlin("gradle-plugin", "1.4.31"))

    implementation(kotlin("android-extensions"))

    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.16.0-RC2")
}

gradlePlugin {
    plugins {
        register("AndroidAppPlugin") {
            id = "AndroidAppPlugin"
            implementationClass = "plugin.AndroidAppPlugin"
        }
        register("AndroidLibraryPlugin") {
            id = "AndroidLibraryPlugin"
            implementationClass = "plugin.AndroidLibraryPlugin"
        }
    }
}
