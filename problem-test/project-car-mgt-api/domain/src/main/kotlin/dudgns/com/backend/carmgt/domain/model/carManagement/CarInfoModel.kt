package dudgns.com.backend.carmgt.domain.model.carManagement

data class CarInfoModel(
    var carIdx: Long,
    var modelName: String? = null,
    val carCategory: List<CarCategoryModel>? = null,
    val company: String? = null,
    val createdYear: Int? = null,
    val rentalYn: Boolean? = null,
)
