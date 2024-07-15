package dudgns.com.backend.carmgt.adapter.data.jpa

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(classes = [CarManagementRepositoryTestApplication::class])
@EntityScan(basePackages = ["dudgns.com.backend.commons.data"])
@ActiveProfiles(
    "adapter-data-jpa-env",
    "adapter-data-jpa-local",
)
annotation class AnnotCarManagementRepositoryTest
