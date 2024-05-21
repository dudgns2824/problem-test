package dudgns.com.backend.carmgt.adapter.data.jpa.repository.carManagement

import dudgns.com.backend.commons.data.entity.problemTest.CarCategoryMappingEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CarCategoryMappingRepository : JpaRepository<CarCategoryMappingEntity, Long> {
    fun findByCarCategoryMappingIdCarIdx(carIdx: Long?) : List<CarCategoryMappingEntity>
}