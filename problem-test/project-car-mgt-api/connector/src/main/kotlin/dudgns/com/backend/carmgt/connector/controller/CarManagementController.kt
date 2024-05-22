package dudgns.com.backend.carmgt.connector.controller

import com.fasterxml.jackson.annotation.JsonProperty
import dudgns.com.backend.carmgt.application.dto.carManagement.GetCarInfoListQueryCommand
import dudgns.com.backend.carmgt.application.dto.carManagement.ModifyCarInfoCommand
import dudgns.com.backend.carmgt.application.dto.carManagement.RegistCarInfoCommand
import dudgns.com.backend.carmgt.application.servicebus.carManagement.`in`.ICarManagementCommandBus
import dudgns.com.backend.carmgt.application.servicebus.carManagement.`in`.ICarManagementQueryBus
import dudgns.com.backend.carmgt.connector.dto.RequestCarModifyDto
import dudgns.com.backend.carmgt.connector.dto.RequestCarRegistDto
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
    private val carManagementQuery: ICarManagementQueryBus,
    private val carManagementCommandBus : ICarManagementCommandBus
) {
    @GetMapping
    @Operation(summary = "자동차 조회 API", description = "자동차 조회 API 입니다.")
    fun lookup(
        @RequestParam(value = "company_code", required = false) companyCode: Int?,
        @RequestParam(value = "rental_yn", required = false) rentalYn: Boolean?,
        @RequestParam(value = "category_code_list", required = false) categoryCodeList: List<Int?>?,
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
            return ResponseEntity.ok(carManagementCommandBus.registCarInfo(req))
        } catch (e: Exception) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null)
        }
    }


    @PutMapping("/{car_idx}")
    @Operation(summary = "자동차 수정 API", description = "자동차 수정 API 입니다.")
    fun carModify(@PathVariable("car_idx") carIdx: Long,
                  @RequestBody req: RequestCarModifyDto): ResponseEntity<*> {
        try {
            val req = ModifyCarInfoCommand(
                carIdx = carIdx,
                categoryTypeList = req.categoryTypeList,
                companyCode = req.companyCode,
                modelName = req.modelName,
                createdYear = req.createdYear,
                rentalYn = req.rentalYn
            )
            return ResponseEntity.ok(carManagementCommandBus.modifyCarInfo(req))
        } catch (e: Exception) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null)
        }
    }

}