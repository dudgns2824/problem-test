package kr.co.hmcnetworks.backoffice.partnershipmgt.adapter.data.jpa.config

import com.querydsl.jpa.JPQLTemplates
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

/** queryDsl 설정 */
@Configuration
@EnableJpaAuditing
class QueryDslConfig(
    @PersistenceContext
    private val entityManager: EntityManager,
) {
    @Bean
    fun jPAQueryFactory() = JPAQueryFactory(JPQLTemplates.DEFAULT, entityManager)
}
