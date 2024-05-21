plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "backend"

include(
    ":commons:infrastructure",
    ":commons:core",
    ":commons:project-dudgns-data-entity"
)

include(
    ":project-car-mgt-api:adapter-data-jpa",
    ":project-car-mgt-api:application",
    ":project-car-mgt-api:bootstrap",
    ":project-car-mgt-api:connector",
    ":project-car-mgt-api:domain"
)