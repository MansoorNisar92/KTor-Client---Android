import extensions.*
import java.util.*
import java.io.FileInputStream

buildscript {
    repositories {
        maven(url = "https://plugins.gradle.org/m2/")
    }
}

repositories {
    maven(url = "https://maven.google.com")
}

plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.hilt)
    id(Plugins.naivgationSageArgs)
    id(Plugins.googleServices)
    id(Plugins.serilization)
}


android {
    compileSdkVersion(AndroidConfig.compileSdk)

    defaultConfig {
        applicationId  = AndroidConfig.applicationId
        minSdkVersion(AndroidConfig.minSdk)
        targetSdkVersion(AndroidConfig.targetSdk)
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName
        testInstrumentationRunner = AndroidConfig.hiltTestRunner
        signingConfig = signingConfigs.getByName("debug")
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = BuildTypeProd.isMinifyEnabled
            isDebuggable = BuildTypeProd.isDebuggable
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            stringBuildConfigField(
                BuildConfigVariables.APP_BASE_URL,
                BuildConfigVariables.RELEASE_APP_BASE_URL
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        dataBinding = true
    }

    kapt {
        generateStubs = true
    }
}

dependencies {
    implementation(Dependencies.kotlinStdLib)
    implementation(Dependencies.kotlinCoreKtx)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.constrainLayout)
    testImplementation(Dependencies.jUnit)
    androidTestImplementation(Dependencies.extJUnit)
    androidTestImplementation(Dependencies.espressoCore)

    implementation(Dependencies.hilt)
    kapt(Dependencies.hiltKapt)
    //hilt testing
    androidTestImplementation(Dependencies.hiltTest)
    testImplementation(Dependencies.coreTesting)
    androidTestImplementation(Dependencies.truth)
    testImplementation(Dependencies.truth)
    /*androidTestImplementation(Dependencies.mockito)
    androidTestImplementation(Dependencies.mockitoAndroid)*/
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.30.1-alpha")
    testImplementation(Dependencies.hiltTest)
    androidTestImplementation("com.squareup.okhttp3:mockwebserver:4.9.3")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.4.0")
    testImplementation ("org.robolectric:robolectric:4.5.1")
    //UI test
    androidTestImplementation ("org.robolectric:robolectric:4.5.1")

    implementation(Dependencies.fragmentKtx)
    implementation(Dependencies.activityKtx)
    implementation(Dependencies.viewModelKtx)

    implementation(Dependencies.coroutines)
// Kotlin
    implementation(Dependencies.navigationFragmentKTX)
    implementation(Dependencies.navigationUiKTX)
    implementation(Dependencies.navigationStackLibrary)
    implementation(Dependencies.navigationStackLibrary)

    //KTOR
    implementation(Dependencies.kTorClientCore)
    implementation(Dependencies.kTorClientAndroid)
    implementation(Dependencies.kTorSerialization)
    implementation(Dependencies.kTorLogging)
   // implementation(Dependencies.logBackClassic)
    implementation(Dependencies.kotlinxSerialization)

    //implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.google.code.gson:gson:2.8.8")
}
