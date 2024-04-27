package com.dudgns.problemtest.repository.carManagement;

import com.dudgns.problemtest.entity.carManagement.CarCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarCategoryRepository extends JpaRepository<CarCategoryEntity, Long> {
}
