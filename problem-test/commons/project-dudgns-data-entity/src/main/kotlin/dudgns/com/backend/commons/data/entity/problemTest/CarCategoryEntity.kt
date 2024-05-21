package dudgns.com.backend.commons.data.entity.problemTest

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "car_category")
class CarCategoryEntity {
    @Id
    @Column(name = "category_type")
    var categoryType: Int? = null

    @Column(name = "category_name")
    var categoryName: String? = null
}