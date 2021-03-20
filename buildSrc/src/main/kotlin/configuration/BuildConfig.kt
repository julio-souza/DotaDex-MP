package configuration

sealed class BuildConfig(
    val name: String,
    val isMinifyEnabled: Boolean,
    val isTestCoverageEnabled: Boolean
)

object ReleaseConfig: BuildConfig("release", true, true)
object DebugConfig: BuildConfig("debug", false, true)
