package dudgns.com.backend.carmgt.application.dto.carManagement

data class GetCarInfoListQueryCommand (
    override var companyCode: Long?,
    override var rentalYn: Boolean?,
    override var startYear: Int?,
    override var endYear: Int?,
    override var categoryTypeList: List<Int?>?
) : IGetCarInfoListDto