package dudgns.com.backend.carmgt.connector.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "자동차 등록 수정 dto")
data class RequestCarModifyDto(
    @Schema(description = "카테고리 타입 목록")
    @JsonProperty(value = "category_type_list")
    val categoryTypeList: List<Int>,
    @Schema(description = "제조사 코드 번호")
    @JsonProperty(value = "company_code")
    val companyCode: Long,
    @Schema(description = "모델 명")
    @JsonProperty(value = "model_name")
    val modelName: String,
    @Schema(description = "생산 년도")
    @JsonProperty(value = "created_year")
    val createdYear: Int,
    @Schema(description = "대여 가능 여부")
    @JsonProperty(value = "rental_yn")
    val rentalYn: Boolean
)