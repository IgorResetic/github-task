package dependencies

object AndroidTestDependencies {
    // // Build plugins android test dependencies
    const val KOTLIN_TEST = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.KOTLIN}"

    // Libraries android test dependencies
    const val ANDROIDX_TEST_EXT = "androidx.test.ext:junit-ktx:${Versions.ANDROIDX_TEST_EXT}"
    const val COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES_VERSION}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}"
    const val ESPRESSO_CONTRIB = "androidx.test.espresso:espresso-contrib:${Versions.ESPRESSO_CORE}"
    const val FRAGMENT_TESTING = "androidx.fragment:fragment-testing:${Versions.FRAGMENT_VERSION}"
    const val HILT_ANDROID_TESTING = "com.google.dagger:hilt-android-testing:${Versions.HILT_ANDROID_TEST}"
    const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT_ANDROID_TEST}"
    const val IDLING_RESOURCE = "androidx.test.espresso:espresso-idling-resource:${Versions.ESPRESSO_IDLING_RESOURCE}"
    const val MOCKK_ANDROID = "io.mockk:mockk-android:${Versions.MOCKK_VERSION}"
    const val NAVIGATION_TESTING = "androidx.navigation:navigation-testing:${Versions.NAV_COMPONENTS}"
    const val TEST_RUNNER = "androidx.test:runner:${Versions.TEST_RUNNER}"
    const val TEST_RULES = "androidx.test:rules:${Versions.TEST_RUNNER}"
    const val TEXT_CORE_KTX = "androidx.test:core-ktx:${Versions.TEST_CORE}"
}
