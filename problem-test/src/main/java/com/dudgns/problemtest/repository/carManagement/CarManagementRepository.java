package com.dudgns.problemtest.repository.carManagement;

import com.dudgns.problemtest.entity.carManagement.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarManagementRepository extends JpaRepository<CarEntity, Long> {
}
