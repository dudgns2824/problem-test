package dudgns.com.backend.carmgt.connector.dto

import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.Size
import org.jetbrains.annotations.NotNull

data class RequestCarModifyDto(
    @NotNull
    val categoryTypeList: List<Int>,
    @NotNull
    @Positive(message = "회사 코드는 무조건 0보다 커야 합니다.")
    val companyCode: Long,
    @NotNull
    val modelName: String,
    @NotNull
    @Size(min = 1900, message = "생산 년도는 1900년 이상으로 입력 해 주세요.")
    val createdYear: Int,
    @NotNull
    val rentalYn: Boolean
)