package dudgns.com.backend.carmgt.connector.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

data class RequestCarModifyDto(
    val categoryTypeList: List<Int>,
    val companyCode: Long,
    val modelName: String,
    val createdYear: Int,
    val rentalYn: Boolean
)