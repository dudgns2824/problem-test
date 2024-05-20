package dudgns.com.backend.commons.infrastructure

import io.kotest.matchers.ints.shouldBeZero
import dudgns.com.backend.commons.infrastructure.config.test.UnitTest
import org.junit.jupiter.api.Test

@UnitTest
class Test01 {
    @Test
    fun a() {
        println("--test01:a() -- unitTest---")
        val a = 0
        a.shouldBeZero()
    }
}

//@IntegrationTest
////@ActiveProfiles("infrastructure-test")
//@ContextConfiguration(
//    classes = [
//        TestApplication::class,
////        AopLoggingConfig::class, AopRequestLoggingProperties::class
//    ],
//)
//class Test02 {
//    @Test
//    fun b() {
//        println("--test02:b() -- integrationTest---")
//    }
//}

//class Test03 {
//    @Test
//    fun c() {
//        println("--test03:c() -- none annotation ---")
//    }
//}