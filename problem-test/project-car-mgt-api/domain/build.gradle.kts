plugins {
    id("spring-common-conventions")

    kotlin("plugin.allopen")
    kotlin("plugin.noarg")
    kotlin("kapt")
}

dependencies {
    implementation(project(":commons:core"))
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