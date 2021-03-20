pluginManagement {
    repositories {
        google()
        jcenter()
        gradlePluginPortal()
        mavenCentral()
    }
    
}
rootProject.name = "DotaDex"


include(":androidApp")
include(":shared:data")
include(":shared:domain")
include(":shared:local")
include(":shared:network")

