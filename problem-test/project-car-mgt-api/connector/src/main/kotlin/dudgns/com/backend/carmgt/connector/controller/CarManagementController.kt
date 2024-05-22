package dudgns.com.backend.carmgt.connector.controller

import com.fasterxml.jackson.annotation.JsonProperty
import dudgns.com.backend.carmgt.application.dto.carManagement.GetCarInfoListQueryCommand
import dudgns.com.backend.carmgt.application.dto.carManagement.ModifyCarInfoCommand
import dudgns.com.backend.carmgt.application.dto.carManagement.RegistCarInfoCommand
import dudgns.com.backend.carmgt.application.servicebus.carManagement.`in`.ICarManagementQueryBus
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@Tag(description = "자동차 조회 API 입니다.", name = "자동차 조회 API")
@RequestMapping("/api/problemTest/carManagement")
@Validated
class CarManagementController(
    private val carManagementQuery: ICarManagementQueryBus
) {
    @GetMapping
    @Operation(summary = "자동차 조회 API", description = "자동차 조회 API 입니다.")
    fun lookup(
        @RequestParam(value = "company_code", required = false) companyCode: Int?,
        @RequestParam(value = "rental_yn", required = false) rentalYn: Boolean?,
        @RequestParam(value = "category_code_list", required = false) categoryCodeList: List<Long?>?,
        @RequestParam(value = "start_year", required = false) startYear: Int?,
        @RequestParam(value = "end_year", required = false) endYear: Int?
    ): ResponseEntity<List<*>> {
        try {
            val req = GetCarInfoListQueryCommand(
                companyCode = companyCode,
                rentalYn = rentalYn,
                categoryTypeList = categoryCodeList,
                startYear = startYear,
                endYear = endYear
            )
            return ResponseEntity.ok(carManagementQuery.getCarInfo(req))
        } catch (e: Exception) {
            return ResponseEntity.status(
                HttpStatus.NOT_FOUND
            ).body(null)
        }
    }

    @PostMapping
    @Operation(summary = "자동차 등록 API", description = "자동차 등록 API 입니다.")
    fun carRegist(@RequestBody req: RequestCarRegistDto): ResponseEntity<*> {
        try {
            val req = RegistCarInfoCommand(
                categoryTypeList = req.categoryTypeList,
                companyCode = req.companyCode,
                modelName = req.modelName,
                createdYear = req.createdYear,
                rentalYn = req.rentalYn
            )
            return ResponseEntity.ok(carManagementQuery.registCarInfo(req))
        } catch (e: Exception) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null)
        }
    }

    @Schema(description = "자동차 등록 요청 dto")
    data class RequestCarRegistDto(
        @Schema(description = "카테고리 타입 목록") @JsonProperty(value = "category_type_list")
        var categoryTypeList: List<Int>,
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


    @PutMapping("/{car_idx}")
    @Operation(summary = "자동차 수정 API", description = "자동차 수정 API 입니다.")
    fun carModify(@PathVariable("car_idx") carIdx: Long, @RequestBody req: RequestCarModifyDto): ResponseEntity<*> {
        try {
            val req = ModifyCarInfoCommand(
                carIdx = carIdx,
                categoryTypeList = req.categoryTypeList,
                companyCode = req.companyCode,
                modelName = req.modelName,
                createdYear = req.createdYear,
                rentalYn = req.rentalYn
            )
            return ResponseEntity.ok(carManagementQuery.modifyCarInfo(req))
        } catch (e: Exception) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null)
        }
    }

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

}