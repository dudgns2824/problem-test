package kr.co.hmcnetworks.backoffice.partnershipmgt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackages = [
        "kr.co.hmcnetworks.backoffice.partnershipmgt",
        "kr.co.hmcnetworks.backoffice.commons",
        "kr.co.hmcnetworks.modules",
    ],
)
@EntityScan(basePackages = ["kr.co.hmcnetworks.backoffice.commons"])
class BackendCarMgtApp

fun main(args: Array<String>) {
    runApplication<BackendCarMgtApp>(*args)
}
