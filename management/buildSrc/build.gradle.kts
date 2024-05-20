plugins {
    `kotlin-dsl`

    kotlin("jvm") version embeddedKotlinVersion apply false
    kotlin("plugin.serialization") version embeddedKotlinVersion // 사용 모듈에서 재 등록 필요
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.kotlin.allopen)
    implementation(libs.kotlin.noarg)
    implementation((libs.kotlin.kapt.gradle.plugin))

    implementation(libs.spring.boot.gradle.plugin)

    implementation(libs.kotlin.serialization.json)
}
