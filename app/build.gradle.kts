plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    kotlin("kapt")
    kotlin("plugin.parcelize")
    alias(libs.plugins.hilt)
}

var versionMajor = 1
var versionMinor = 0
var versionPatch = 0

//var keystorePropertiesFile = rootProject.file("ext.gradle")
//var keystoreProperties = Properties()
//keystoreProperties.load(FileInputStream(keystorePropertiesFile))

android {
    namespace = "com.android.baseapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.android.baseapp"
        minSdk = 28
        targetSdk = 36
        versionCode =((versionMajor * 100000)+ (versionMinor * 1000)+ (versionPatch * 10))
        versionName ="${versionMajor}.${versionMinor}.${versionPatch}"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    /*
    signingConfigs {
        create("MySigningConfig") {
            keyAlias = "BaseApp"
            keyPassword = "KeyPassword"
            storeFile = file("../keystore/keystore")
            storePassword = "KeyPassword"
        }
    }*/

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            //signingConfig = signingConfigs["MySigningConfig"]
            versionNameSuffix= "_release"
        }
        debug {
            isMinifyEnabled = false
            versionNameSuffix= "_dev"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_1_8)
        }
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.paging)
    implementation(libs.androidx.datastore)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(kotlin("reflect"))
    //Lottie
    implementation(libs.lottie)
    //KotPref
    implementation(libs.kotpref)
    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.convertergson)
    implementation(libs.okhttp3)
    implementation(libs.okhttp3.logging.interceptor)
    //Coroutines
    implementation(libs.coroutines)
    //Glide
    implementation(libs.glide)
    //Room
    implementation(libs.room)
    kapt(libs.room.compiler)
    //Hilt
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)
    kapt(libs.hilt.navigation)
    //Security
    implementation(libs.androidx.security)
}