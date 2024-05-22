package dudgns.com.backend.carmgt.adapter.data.jpa.config

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.DependsOn
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy
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

    @Bean
    @Primary
    @DependsOn(
        "masterDataSource"
    )
    fun routingDataSource(
        @Qualifier(MASTER_DATASOURCE) masterDataSource: DataSource?
    ): DataSource {
        val routingDataSource = RoutingDataSource()
        val datasourceMap: HashMap<Any?, Any?> =
            object : HashMap<Any?, Any?>() {
                init {
                    put(
                        DataSourceType.MASTER,
                        masterDataSource,
                    )
                }
            }
        routingDataSource.setTargetDataSources(datasourceMap)
        routingDataSource.setDefaultTargetDataSource(masterDataSource!!)
        return routingDataSource
    }

    @Bean
    @DependsOn("routingDataSource")
    fun dataSource(routingDataSource: DataSource?): LazyConnectionDataSourceProxy {
        return LazyConnectionDataSourceProxy(routingDataSource!!)
    }
}
