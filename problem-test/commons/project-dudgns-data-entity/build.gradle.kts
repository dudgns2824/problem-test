plugins {
    id("spring-common-conventions")

    kotlin("plugin.allopen")
    kotlin("plugin.noarg")
    kotlin("kapt")
}

dependencies {
    implementation(project(":commons:core"))

    implementation(libs.bundles.commons.project.dudgns.data.entity)
    implementation(libs.spring.data.querydsl.jpa) {
        artifact {
            classifier = "jakarta"
        }
    }

    kapt(libs.spring.data.querydsl.apt) {
        artifact {
            classifier = "jakarta"
        }
    }
    kapt(libs.bundles.commons.project.dudgns.data.entity.kapt)

    testImplementation(libs.bundles.test.junit)
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

noArg {
    annotation("jakarta.persistence.Entity")
}

kapt {
    correctErrorTypes = true
}
