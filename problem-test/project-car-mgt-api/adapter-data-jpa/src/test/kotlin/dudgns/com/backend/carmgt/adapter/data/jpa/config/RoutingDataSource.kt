package dudgns.com.backend.carmgt.adapter.data.jpa.config

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
import org.springframework.transaction.support.TransactionSynchronizationManager

/** @Transactional(readOnly = true) 여부에 따라서 DataSource를 결정할 수 있도록 구현 */
class RoutingDataSource : AbstractRoutingDataSource() {
    override fun determineCurrentLookupKey(): Any {
        return DataSourceType.MASTER
    }
}
