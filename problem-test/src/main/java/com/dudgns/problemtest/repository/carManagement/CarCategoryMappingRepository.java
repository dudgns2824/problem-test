package com.dudgns.problemtest.repository.carManagement;

import com.dudgns.problemtest.entity.carManagement.CarCategoryMappingEntity;
import com.dudgns.problemtest.entity.id.CarCategoryMappingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarCategoryMappingRepository extends JpaRepository<CarCategoryMappingEntity, Long> {
    List<CarCategoryMappingEntity> findByCarCategoryMappingId(CarCategoryMappingId carCategoryMappingId);
}
