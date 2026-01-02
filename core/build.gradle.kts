@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
  alias(libs.plugins.kotlinMultiplatform)
  alias(libs.plugins.androidLibrary)
}

kotlin {
  // Android target using Android Multiplatform Library
  androidTarget {
    compilerOptions {
      jvmTarget.set(JvmTarget.JVM_11)
    }
  }

  // iOS targets
  iosArm64()
  iosX64()
  iosSimulatorArm64()

  // Web JS target
  js(IR) {
    browser()
    nodejs()
  }

  // Web WASM target
  wasmJs {
    browser()
    nodejs()
  }

  // Desktop target (works on all desktop platforms: Linux, macOS, Windows)
  jvm("desktop")

  // Server/JVM target
  jvm("server")

  sourceSets {
    // Common source sets
    val commonMain by getting {
      dependencies {
        // Common dependencies
      }
    }
    val commonTest by getting {
      dependencies {
        implementation(libs.kotlin.test)
      }
    }

    // Android source set
    val androidMain by getting {
      dependencies {
        // Android-specific dependencies
      }
    }

    // iOS source sets
    val iosX64Main by getting
    val iosArm64Main by getting
    val iosSimulatorArm64Main by getting
    val iosMain by creating {
      dependsOn(commonMain)
      iosX64Main.dependsOn(this)
      iosArm64Main.dependsOn(this)
      iosSimulatorArm64Main.dependsOn(this)
    }

    // Desktop source set (shared across all desktop platforms)
    val desktopMain by getting {
      dependsOn(commonMain)
    }

    // Server source set
    val serverMain by getting {
      dependsOn(commonMain)
    }

    // Web source sets
    val jsMain by getting {
      dependsOn(commonMain)
    }

    val wasmJsMain by getting {
      dependsOn(commonMain)
    }
  }
}

android {
  namespace = "com.alorma.fireandforget.core"
  compileSdk = libs.versions.android.compileSdk.get().toInt()

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }

  defaultConfig {
    minSdk = libs.versions.android.minSdk.get().toInt()
  }
}
