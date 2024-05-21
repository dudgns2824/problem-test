package dudgns.com.backend.commons.data.entity.problemTest

import dudgns.com.backend.commons.data.entity.problemTest.id.CarCategoryMappingId
import jakarta.persistence.Column
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "car_category_mapping")
class CarCategoryMappingEntity {
    constructor(carCategoryMappingId: CarCategoryMappingId?, categoryName: String?) {
        this.carCategoryMappingId = carCategoryMappingId
        this.categoryName = categoryName!!
    }

    @EmbeddedId
    var carCategoryMappingId: CarCategoryMappingId? = null

    @Column(name = "category_name")
    var categoryName: String = ""
}