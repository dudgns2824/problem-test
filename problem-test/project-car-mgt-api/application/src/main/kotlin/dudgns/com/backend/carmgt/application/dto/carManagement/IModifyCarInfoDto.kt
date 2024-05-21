package dudgns.com.backend.carmgt.application.dto.carManagement

interface IModifyCarInfoDto {
    var carIdx: Long

    var categoryTypeList: List<Int>

    var companyCode: Long

    var modelName: String

    var createdYear: Int

    var rentalYn: Boolean
}