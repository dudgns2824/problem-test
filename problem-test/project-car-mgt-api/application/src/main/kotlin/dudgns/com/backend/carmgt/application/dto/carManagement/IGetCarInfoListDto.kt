package dudgns.com.backend.carmgt.application.dto.carManagement

interface IGetCarInfoListDto {
    var companyCode: Int?
    var rentalYn: Boolean?
    var startYear: Int?
    var endYear: Int?
    var categoryTypeList: List<Long?>?
}