package dudgns.com.backend.carmgt.connector.annotation.docs.carManagement.v1

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.ExampleObject
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@Operation(
    summary = "자동차 등록 API",
    description = "자동차를 등록하기 위한 API",
    parameters = [
        Parameter(
            name = "categoryTypeList",
            description = "카테고리 타입 리스트 (배열)",
            required = true
        ),
        Parameter(
            name = "companyCode",
            description = "제조사 코드 번호",
            required = true
        ),
        Parameter(
            name = "modelName",
            description = "모델 명",
            required = true
        ),
        Parameter(
            name = "createdYear",
            description = "생산 년도",
            required = true
        ),
        Parameter(
            name = "rentalYn",
            description = "대여 가능 여부",
            required = true,
            examples = [
                ExampleObject(name = "가능", value = "true"),
                ExampleObject(name = "불가능", value = "false"),
            ]
        )
    ]
)
@ApiResponses(
    value = [
        ApiResponse(
            responseCode = "200",
            description = "Car Regist Success",
        )]
)
annotation class CarManagementRegistDocs