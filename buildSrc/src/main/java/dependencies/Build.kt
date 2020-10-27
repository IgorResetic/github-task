package dependencies

object Build {
    // Build plugins
    const val BUILD_TOOLS = "com.android.tools.build:gradle:${Versions.GRADLE}"
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
    const val DETEKT = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${Versions.DETEKT}"

    // Libraries
    const val GOOGLE_SERVICES = "com.google.gms:google-services:${Versions.PLAY_SERVICES}"
    const val JUNIT5 = "de.mannodermaus.gradle.plugins:android-junit5:${Versions.JUNIT_5_VERSION}"
    const val FABRIC = "io.fabric.tools:gradle:${Versions.FABRIC_VERSION}"
    const val HILT = "com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT}"
    const val NAVIGATION_SAFE_ARGS = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.NAV_COMPONENTS}"
}
