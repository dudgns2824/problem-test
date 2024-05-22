package dudgns.com.backend.carmgt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackages = [
        "dudgns.com.backend.carmgt",
        "dudgns.com.backend.commons"
    ],
)
@EntityScan(basePackages = ["dudgns.com.backend.commons.data"])
class BackendCarMgtApp

fun main(args: Array<String>) {
    runApplication<BackendCarMgtApp>(*args)
}
