buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0-RC")
    }
}

repositories {
    google()
    mavenCentral()
    maven("https://jitpack.io")
}

plugins {
    kotlin("multiplatform") version "1.6.0-RC"
    id("com.google.devtools.ksp") version "1.6.0-RC-1.0.1-RC"
}

kotlin {
    jvm("android") {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }

    ios()
    iosSimulatorArm64()

    js(IR) {
        browser()
        binaries.executable()
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation("com.github.glureau.kustomexport:lib:-SNAPSHOT")
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
    }
}
dependencies {
    add("kspJs", "com.github.glureau.kustomexport:compiler:-SNAPSHOT")
    add("kspAndroid", "com.github.glureau.kustomexport:compiler:-SNAPSHOT")
}
