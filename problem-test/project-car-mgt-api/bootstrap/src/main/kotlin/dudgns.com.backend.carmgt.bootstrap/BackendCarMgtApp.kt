package dudgns.com.backend.partnershipmgt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackages = [
        "dudgns.com.backend.partnershipmgt",
        "dudgns.com.backend.commons",
        "kr.co.hmcnetworks.modules",
    ],
)
@EntityScan(basePackages = ["dudgns.com.backend.commons"])
class BackendCarMgtApp

fun main(args: Array<String>) {
    runApplication<BackendCarMgtApp>(*args)
}
