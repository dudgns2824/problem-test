plugins {
    id("spring-common-conventions")
}

dependencies {
    implementation(project(":commons:core"))

    implementation(libs.bundles.commons.infrastructure)
    implementation(libs.bundles.test.junit)

    testImplementation(libs.bundles.test.kotest)
}
