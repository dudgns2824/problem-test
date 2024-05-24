package dudgns.com.backend.carmgt.connector.annotation.docs.carManagement.v1

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.ExampleObject
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@Operation(
    summary = "자동차 조회 API",
    description = "조건 검색 결과 list 반환, 모든 파라미터는 optional, 파라미터 없거나 값 존재하지 않으면 전체조건 적용",
    parameters = [
        Parameter(
            name = "companyCode",
            description = "회사 코드",
            required = false
        ),
        Parameter(
            name = "rentalYn",
            description = "대여 가능 여부",
            required = false,
            examples = [
                ExampleObject(name = "가능", value = "true"),
                ExampleObject(name = "불가능", value = "false"),
            ]
        ),
        Parameter(
            name = "categoryCodeList",
            description = "검색할 카테고리 코드 리스트 (배열)",
            required = false
        ),
        Parameter(
            name = "startYear",
            description = "생산 년도 검색 범위 시작 연도",
            required = false
        ),
        Parameter(
            name = "endYear",
            description = "생산 년도 검색 범위 끝 연도",
            required = false
        )
    ]
)
@ApiResponses(
    value = [
        ApiResponse(
            responseCode = "200",
            description = "Car found",
        )]
)
annotation class CarManagementLookupApiDocs