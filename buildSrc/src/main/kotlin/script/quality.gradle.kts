package script

import io.gitlab.arturbosch.detekt.Detekt

plugins {
    id("io.gitlab.arturbosch.detekt")
}

tasks {
    val detektAll by registering(Detekt::class) {
        parallel = true
        setSource(files(projectDir))
        include("**/*.kt")
        include("**/*.kts")
        exclude("**/resources/**")
        exclude("**/build/**")
        config.setFrom("$rootDir/config/detekt/detekt.yml")

        autoCorrect = true

        buildUponDefaultConfig = false

        reports {
            html.enabled = true
            xml.enabled = false
            txt.enabled = false

        }
    }

    getByPath(":androidApp:preBuild").dependsOn(detektAll)

    create("clean") {
        delete(rootProject.buildDir)
    }
}
