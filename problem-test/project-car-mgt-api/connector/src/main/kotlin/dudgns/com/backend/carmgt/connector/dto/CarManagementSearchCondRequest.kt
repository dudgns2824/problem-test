package dudgns.com.backend.carmgt.connector.dto

data class CarManagementSearchCondRequest(
    val companyCode: Long? = null,
    val rentalYn: Boolean? = null,
    val categoryCodeList: List<Int?>? = null,
    val startYear: Int? = null,
    val endYear: Int? = null,
) {
}