package dudgns.com.backend.carmgt.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration

@SpringBootApplication(
    scanBasePackages = ["dudgns.com.backend.carmgt"],
    exclude = [DataSourceAutoConfiguration::class],
)
class CarManagementServiceTestApplication
