@Suppress("unused", "MayBeConstant")
object Dependencies {
    const val kotlinStdLib = "androidx.core:core-ktx:${Versions.kotlinVersionStdLib}"
    const val kotlinCoreKtx = "androidx.core:core-ktx:${Versions.kotlinVersion}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModelKtx}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.appCompat}"
    const val constrainLayout = "androidx.constraintlayout:constraintlayout:${Versions.constrainLayout}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltKapt = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltTest = "com.google.dagger:hilt-android-testing:${Versions.hilt}"
    const val hiltTestKapt = "com.google.dagger:hilt-android-testing:${Versions.hilt}"
    const val coreTesting = "androidx.arch.core:core-testing:${Versions.coreTesting}"
    const val truth =  "com.google.truth:truth:${Versions.truthVersion}"
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val extJUnit = "androidx.test.ext:junit:${Versions.extJUnit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockitoAndroid = "org.mockito:mockito-android:${Versions.mockito}"
    const val navigationFragmentKTX = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUiKTX = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigationStackLibrary = "com.ncapdevi:frag-nav:${Versions.ncapNavigation}"

    const val kTorClientCore =  "io.ktor:ktor-client-core:${Versions.kTorVersion}"
    const val kTorClientAndroid =  "io.ktor:ktor-client-android:${Versions.kTorVersion}"
    const val kTorSerialization =  "io.ktor:ktor-client-serialization:${Versions.kTorVersion}"
    const val kTorLogging =  "io.ktor:ktor-client-logging:${Versions.kTorVersion}"
    const val logBackClassic =  "ch.gos.logback:logback-classic:1.2.3"
    const val kotlinxSerialization =  "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0"
}