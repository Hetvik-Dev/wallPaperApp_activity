plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")

//    kotlin("jvm") version "2.0.10"
//    kotlin("plugin.serialization") version "2.0.10"
}

android {
    namespace = "com.example.wallpaperapp_activity"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.wallpaperapp_activity"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
        buildFeatures {
            viewBinding = true
        }

}

dependencies {
    //serializer
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.1")

        // retrofit API thing
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //dependency injections
    implementation("com.google.dagger:hilt-android:2.44")
    implementation(libs.androidx.contentpager)
    kapt("com.google.dagger:hilt-android-compiler:2.44")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}