package dudgns.com.backend.carmgt.adapter.data.jpa.repository.carManagement

import dudgns.com.backend.commons.data.entity.problemTest.CarEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CarRepository : JpaRepository<CarEntity, Long>
