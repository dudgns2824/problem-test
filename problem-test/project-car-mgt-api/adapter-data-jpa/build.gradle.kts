plugins {
    id("spring-common-conventions")

    kotlin("plugin.allopen")
    kotlin("plugin.noarg")
    kotlin("kapt")
}

dependencies {
    implementation(project(":project-car-mgt-api:application"))
    implementation(project(":project-car-mgt-api:domain"))

    implementation(project(":commons:core"))
    implementation(project(":commons:project-dudgns-data-entity"))

    implementation(libs.bundles.project.car.mgt.adapter.data.jpa)
    implementation(libs.spring.data.querydsl.jpa) {
        artifact {
            classifier = "jakarta"
        }
    }

    kapt(libs.bundles.project.car.mgt.adapter.data.jpa.kapt)
    kapt(libs.spring.data.querydsl.apt) {
        artifact {
            classifier = "jakarta"
        }
    }

    testImplementation(libs.bundles.project.car.mgt.adapter.data.jpa.test)
    testImplementation(libs.bundles.test.junit)
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