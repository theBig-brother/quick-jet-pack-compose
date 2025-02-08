plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.lzf.quickcheck"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.lzf.quickcheck"
        minSdk = 23
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
    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = "1.5.0"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    // Jetpack Compose 依赖（核心）
    implementation("androidx.activity:activity-compose:1.7.2") // 支持 Compose 版 Activity
    implementation("androidx.compose.ui:ui:1.5.0") // 更新为与 Kotlin Compiler Extension 兼容的版本
    implementation("androidx.compose.material3:material3:1.1.2") // Material3 组件库（按钮、卡片等）
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.2") // 支持 Compose 版生命周期管理
    //权限控制
    implementation ("com.google.accompanist:accompanist-permissions:0.24.7-alpha")

    implementation(libs.androidx.ui.tooling.preview.android)
    // ✅ 解决 Navigation 问题
    implementation(libs.androidx.navigation.compose) // Jetpack Compose Navigation

    // CameraX 依赖（用于简化相机操作）
    implementation("androidx.camera:camera-core:1.4.1") // CameraX 核心库
    implementation("androidx.camera:camera-camera2:1.4.1") // 基于 Camera2 API 的 CameraX 适配器
    implementation("androidx.camera:camera-lifecycle:1.4.1") // 让 CameraX 绑定生命周期，自动管理相机状态
    implementation(libs.androidx.camera.view) // 提供 CameraX 预览控件（PreviewView）
//BottomNavigationView
//    implementation ("com.google.android.material:material:1.1.0")
}