package kr.co.hmcnetworks.backoffice.commons.infrastructure

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration

@SpringBootApplication(
    exclude = [
        DataSourceAutoConfiguration::class, // jdbc용
//        AopLoggingConfig::class
    ]
)
class TestApplication
