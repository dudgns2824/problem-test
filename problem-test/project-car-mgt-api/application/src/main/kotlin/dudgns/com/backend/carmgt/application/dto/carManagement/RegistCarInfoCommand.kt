package dudgns.com.backend.carmgt.application.dto.carManagement

data class RegistCarInfoCommand(
    override var categoryTypeList: List<Int>,
    override var companyCode: Long,
    override var modelName: String,
    override var createdYear: Int,
    override var rentalYn: Boolean
) : IRegistCarInfoDto