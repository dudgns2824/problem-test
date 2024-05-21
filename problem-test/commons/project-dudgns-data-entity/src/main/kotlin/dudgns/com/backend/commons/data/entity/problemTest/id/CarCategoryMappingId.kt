package dudgns.com.backend.commons.data.entity.problemTest.id

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
class CarCategoryMappingId : Serializable {
    @Column(name = "car_idx", nullable = false, updatable = false)
    var carIdx: Long? = null

    @Column(name = "category_type", nullable = false, updatable = false)
    var categoryType: Int? = null
}