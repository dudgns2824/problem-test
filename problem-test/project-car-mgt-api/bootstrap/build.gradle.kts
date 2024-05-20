plugins {
    id("spring-common-conventions")

    kotlin("plugin.allopen")
    kotlin("plugin.noarg")
    kotlin("kapt")
}

dependencies {
    implementation(project(":project-car-mgt-api:connector"))
    implementation(project(":project-car-mgt-api:adapter-data-jpa"))
    implementation(project(":project-car-mgt-api:connector"))
    implementation(project(":project-car-mgt-api:domain"))

    implementation(project(":commons:core"))
    implementation(project(":commons:infrastructure"))

    implementation(libs.bundles.project.car.mgt.bootstrap)
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
    annotation("org.springframework.stereotype.Repository")
}

noArg {
    annotation("jakarta.persistence.Entity")
}