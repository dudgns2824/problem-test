package com.dudgns.problemtest.repository.carManagement;

import com.dudgns.problemtest.entity.carManagement.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
}
