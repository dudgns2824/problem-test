plugins {
    // Support convention plugins written in Kotlin.
    // Convention plugins are build scripts in 'src/main' that automatically become available as plugins in the main build.
    `kotlin-dsl`

    kotlin("jvm") version embeddedKotlinVersion apply false
    kotlin("plugin.serialization") version embeddedKotlinVersion // 사용 모듈에서 재 등록 필요
}

repositories {
    // Use the plugin portal to apply community plugins in convention plugins.
    gradlePluginPortal()
}

dependencies {
    // implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    implementation(libs.kotlin.gradle.plugin)

    // spring-base-conventions.gradle.kts 의 plugin 사용을 위해 추가
    implementation(libs.kotlin.allopen)
    implementation(libs.kotlin.noarg)
    implementation((libs.kotlin.kapt.gradle.plugin))

    implementation(libs.spring.boot.gradle.plugin)

    implementation(libs.kotlin.serialization.json)
}
