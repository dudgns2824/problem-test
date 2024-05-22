package dudgns.com.backend.carmgt.adapter.data.jpa.repository.carManagement

import dudgns.com.backend.commons.data.entity.problemTest.CarEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CarRepository : JpaRepository<CarEntity, Long> {
    @Query(
        "select c " +
                "from CarEntity c " +
                "join fetch c.carCategoryMappingEntityList " +
                "left join fetch c.companyEntity " +
                "where (?1 is null or c.companyEntity.companyCode = ?1)" +
                "AND (?2 is null or c.rentalYn = ?2)" +
                "AND (?3 is null or c.createdYear >= ?3)" +
                "AND (?4 is null or c.createdYear <= ?4) " +
                "AND (?5 is null or c.idx IN (SELECT ccm.carCategoryMappingId.carIdx" +
                "                               FROM CarCategoryMappingEntity ccm" +
                "                              WHERE 1=1 " +
                "                                AND ccm.carCategoryMappingId.categoryType IN (?5)))"
    )
    fun findAllBySearchValue(
        companyCode: Long?,
        rentalYn: Boolean?,
        startYear: Int?,
        endYear: Int?,
        categoryTypeList: List<Int?>?
    ): List<CarEntity?>?
}