package dudgns.com.backend.carmgt.connector.dto

data class RequestCarRegistDto(
    val categoryTypeList: List<Int>,
    val companyCode: Long,
    val modelName: String,
    val createdYear: Int,
    val rentalYn: Boolean
)