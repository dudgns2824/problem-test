package dudgns.com.backend.carmgt.connector.controller

import dudgns.com.backend.carmgt.application.dto.carManagement.GetCarInfoListQueryCommand
import dudgns.com.backend.carmgt.application.dto.carManagement.ModifyCarInfoCommand
import dudgns.com.backend.carmgt.application.dto.carManagement.RegistCarInfoCommand
import dudgns.com.backend.carmgt.application.servicebus.carManagement.`in`.ICarManagementCommandBus
import dudgns.com.backend.carmgt.application.servicebus.carManagement.`in`.ICarManagementQueryBus
import dudgns.com.backend.carmgt.connector.annotation.docs.carManagement.v1.CarManagementLookupApiDocs
import dudgns.com.backend.carmgt.connector.annotation.docs.carManagement.v1.CarManagementModifyDocs
import dudgns.com.backend.carmgt.connector.annotation.docs.carManagement.v1.CarManagementRegistDocs
import dudgns.com.backend.carmgt.connector.annotation.docs.carManagement.v1.validation.CheckCarIdx
import dudgns.com.backend.carmgt.connector.dto.CarManagementSearchCondRequest
import dudgns.com.backend.carmgt.connector.dto.RequestCarModifyDto
import dudgns.com.backend.carmgt.connector.dto.RequestCarRegistDto
import dudgns.com.backend.commons.infrastructure.util.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springdoc.core.annotations.ParameterObject
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
    private val carManagementCommandBus: ICarManagementCommandBus,
) {
    @GetMapping
    @CarManagementLookupApiDocs
    fun lookup(
        @ParameterObject @ModelAttribute carManagementSearchCondRequest: CarManagementSearchCondRequest,
    ): ResponseEntity<Any> {
        try {
            val req =
                GetCarInfoListQueryCommand(
                    companyCode = carManagementSearchCondRequest.companyCode,
                    rentalYn = carManagementSearchCondRequest.rentalYn,
                    categoryTypeList = carManagementSearchCondRequest.categoryCodeList,
                    startYear = carManagementSearchCondRequest.startYear,
                    endYear = carManagementSearchCondRequest.endYear,
                )

            val data = carManagementQuery.getCarInfo(req)
            return ResponseEntity.ok(ApiResponse.ok(data))
        } catch (e: Exception) {
            return ResponseEntity.status(
                HttpStatus.NOT_FOUND,
            ).body(null)
        }
    }

    @PostMapping
    @CarManagementRegistDocs
    fun carRegist(
        @Valid @RequestBody req: RequestCarRegistDto,
    ): ResponseEntity<Any> {
        try {
            val req =
                RegistCarInfoCommand(
                    categoryTypeList = req.categoryTypeList,
                    companyCode = req.companyCode,
                    modelName = req.modelName,
                    createdYear = req.createdYear,
                    rentalYn = req.rentalYn,
                )
            return ResponseEntity.ok(carManagementCommandBus.registCarInfo(req))
        } catch (e: Exception) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null)
        }
    }

    @PutMapping("/{car_idx}")
    @CarManagementModifyDocs
    fun carModify(
        @CheckCarIdx @PathVariable carIdx: Long,
        @Valid @RequestBody req: RequestCarModifyDto,
    ): ResponseEntity<Any> {
        try {
            val req =
                ModifyCarInfoCommand(
                    carIdx = carIdx,
                    categoryTypeList = req.categoryTypeList,
                    companyCode = req.companyCode,
                    modelName = req.modelName,
                    createdYear = req.createdYear,
                    rentalYn = req.rentalYn,
                )
            return ResponseEntity.ok(carManagementCommandBus.modifyCarInfo(req))
        } catch (e: Exception) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null)
        }
    }
}
