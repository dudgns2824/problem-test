package dudgns.com.backend.carmgt.adapter.data.jpa

import dudgns.com.backend.carmgt.adapter.data.jpa.config.QueryDslConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.context.annotation.Import

@Import(value = [QueryDslConfig::class])
@SpringBootApplication(
    scanBasePackages = ["dudgns.com.backend.carmgt.adapter.data.jpa"],
    exclude = [DataSourceAutoConfiguration::class],
)
class CarManagementRepositoryTestApplication
