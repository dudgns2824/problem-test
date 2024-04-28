package com.dudgns.problemtest.repository.carManagement;

import com.dudgns.problemtest.entity.carManagement.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

    @Query("select c " +
            "from CarEntity c " +
            "join fetch c.carCategoryMappingEntityList " +
            "left join fetch c.companyEntity " +
            "where (?1 is null or c.companyEntity.companyCode = ?1)" +
            "AND (?2 is null or c.rentalYn = ?2)" +
            "AND (?3 is null or c.createdYear >= ?3)" +
            "AND (?4 is null or c.createdYear <= ?4) ")
    List<CarEntity> findAllBySearchValue(Integer companyCode, Boolean rentalYn, Integer startYear, Integer endYear);
}
