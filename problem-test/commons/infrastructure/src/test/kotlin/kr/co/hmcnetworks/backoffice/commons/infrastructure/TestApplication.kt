package dudgns.com.backend.commons.infrastructure

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration

@SpringBootApplication(
    exclude = [
        DataSourceAutoConfiguration::class, // jdbc용
//        AopLoggingConfig::class
    ]
)
class TestApplication
