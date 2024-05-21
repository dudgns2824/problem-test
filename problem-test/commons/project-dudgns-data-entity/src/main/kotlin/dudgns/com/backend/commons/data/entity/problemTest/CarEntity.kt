package dudgns.com.backend.commons.data.entity.problemTest

import jakarta.persistence.*

@Entity
@Table(name = "car")
class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Long? = null

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_idx", insertable = false, updatable = false)
    val carCategoryMappingEntityList: List<CarCategoryMappingEntity> = ArrayList<CarCategoryMappingEntity>()

    @Column(name = "company_code", insertable = true, updatable = true)
    var companyCode: Long? = null

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_code", referencedColumnName = "company_code", insertable = false, updatable = false)
    var companyEntity: CompanyEntity? = null

    @Column(name = "model_name")
    var modelName: String? = null

    @Column(name = "created_year")
    var createdYear: Int? = null

    @Column(name = "rental_yn")
    var rentalYn: Boolean? = null

    constructor(
        idx: Long?,
        companyCode: Long,
        modelName: String,
        createdYear: Int,
        rentalYn: Boolean
    ) {
        this.idx = idx
        this.companyCode = companyCode
        this.modelName = modelName
        this.createdYear = createdYear
        this.rentalYn = rentalYn
    }
}