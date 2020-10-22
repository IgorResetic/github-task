package dependencies

object Dependencies {

    // Build plugins dependencies
    const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect:${Versions.KOTLIN}"
    const val KOTLIN_STANDARD_LIBRARY = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN}"

    // Libraries
    const val HILT_ANDROID = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val HILT_ANDROID_COMPILTER = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
    const val HILT_VIEWMODEL = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.HILT_VIEWMODEL}"
    const val HILT_COMPILTER = "androidx.hilt:hilt-compiler:${Versions.HILT_VIEWMODEL}"
    const val KOTLIN_COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES_VERSION}"
    const val KOTLIN_COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:" +
            Versions.COROUTINES_VERSION
    const val KTX = "androidx.core:core-ktx:${Versions.KTX}"
    const val KOTLIN_COROUTINES_PLAY_SERVICES = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:" +
            Versions.COROUTINES_PLAY_SERVICES
    const val LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime:${Versions.LIFECYCLE_VERSION}"
    const val LIFECYCLE_COROUTINES = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE_VERSION}"
    const val MATERIAL_DIALOGS = "com.afollestad.material-dialogs:core:${Versions.MATERIAL_DESIGN}"
    const val MATERIAL_DIALOGS_INPUT = "com.afollestad.material-dialogs:input:${Versions.MATERIAL_DIALOGS}"
    const val MARKDOWN_PROCESSOR = "com.yydcdut:markdown-processor:${Versions.MARKDOWN_PROCESSOR}"
    const val MOSHI = "com.squareup.moshi:moshi:${Versions.MOSHI}"
    const val MOSHI_KOTLIN = "com.squareup.moshi:moshi-kotlin:${Versions.MOSHI}"
    const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${Versions.NAV_COMPONENTS}"
    const val NAVIGATION_RUNTIME = "androidx.navigation:navigation-runtime:${Versions.NAV_COMPONENTS}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${Versions.NAV_COMPONENTS}"
    const val PLAY_CORE = "com.google.android.play:core:${Versions.PLAY_CORE}"
    const val ROOM_RUNTIME = "androidx.room:room-runtime:${Versions.ROOM}"
    const val ROOM_KTX = "androidx.room:room-ktx:${Versions.ROOM}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT2_VERSION}"
    const val RETROFIT_GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT2_VERSION}"
    const val RETROFIT_MOSHI = "com.squareup.retrofit2:converter-moshi:${Versions.RETROFIT2_VERSION}"
    const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"
}
