package dudgns.com.backend.carmgt.connector.dto

import org.jetbrains.annotations.NotNull

data class RequestCarModifyDto(
    @NotNull
    val categoryTypeList: List<Int>,
    @NotNull
    val companyCode: Long,
    @NotNull
    val modelName: String,
    @NotNull
    val createdYear: Int,
    @NotNull
    val rentalYn: Boolean
)