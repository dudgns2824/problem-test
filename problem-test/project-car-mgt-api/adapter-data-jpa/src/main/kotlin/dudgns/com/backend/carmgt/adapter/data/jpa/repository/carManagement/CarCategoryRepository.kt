package dudgns.com.backend.carmgt.adapter.data.jpa.repository.carManagement

import dudgns.com.backend.commons.data.entity.problemTest.CarCategoryEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CarCategoryRepository : JpaRepository<CarCategoryEntity, Int> {
}