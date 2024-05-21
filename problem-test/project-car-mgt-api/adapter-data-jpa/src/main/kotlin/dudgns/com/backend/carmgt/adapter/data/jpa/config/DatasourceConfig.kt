package kr.co.hmcnetworks.backoffice.partnershipmgt.adapter.data.jpa.config

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
@EnableConfigurationProperties(
    value = [DatabaseProperties::class],
)
class DatasourceConfig(
    private val dbProps: DatabaseProperties,
) {
    companion object {
        const val MASTER_DATASOURCE = "masterDataSource"
    }

    @Bean(MASTER_DATASOURCE)
    fun masterDataSource(): DataSource {
        return DataSourceBuilder.create()
            .driverClassName(dbProps.master.driverClassName)
            .url(dbProps.master.jdbcUrl)
            .username(dbProps.master.username)
            .password(dbProps.master.password)
            .build()
    }
}
