package dudgns.com.backend.carmgt.application.dto.carManagement

interface IGetCarInfoListDto {
    var companyCode: Long?
    var rentalYn: Boolean?
    var startYear: Int?
    var endYear: Int?
    var categoryTypeList: List<Int?>?
}