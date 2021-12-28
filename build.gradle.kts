// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(ProjectPlugins.pathGradle)
        classpath(ProjectPlugins.pathGradleKotlin)
        classpath(ProjectPlugins.pathHilt)
        classpath(ProjectPlugins.googleServices)
        classpath(ProjectPlugins.navigation)
        classpath(ProjectPlugins.kotlinSerialization)
    }


}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon

    }
}

tasks.create<Delete>("cleanRP") {
    group = "rp"
    delete = setOf (
        "rp-out", "rp-zip"
    )
}
