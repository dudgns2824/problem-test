package kr.co.hmcnetworks.backoffice.commons.infrastructure.config.test

import org.junit.jupiter.api.Tag
import org.springframework.boot.test.context.SpringBootTest

@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Tag(TestType.UNIT_TEST)
annotation class UnitTest

@SpringBootTest
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Tag(TestType.INTEGRATION_TEST)
annotation class IntegrationTest
/**
 * how to use
 * springBootTest 사용으로 springBootApplicatoin 지정 필요
 *
 * @IntegrationTest
 * @ContextConfiguration(classes = [TestApplication::class])
 */