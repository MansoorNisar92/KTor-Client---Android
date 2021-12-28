@Suppress("unused", "SpellCheckingInspection")
object ProjectPlugins {
    const val pathGradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val pathGradleKotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.gradlePlugin}"
    const val pathHilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    const val googleServices = "com.google.gms:google-services:${Versions.googleServicesPlugin}"
    const val navigation = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
    const val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:1.5.21"

}