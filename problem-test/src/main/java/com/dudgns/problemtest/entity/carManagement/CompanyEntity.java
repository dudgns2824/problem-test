package com.dudgns.problemtest.entity.carManagement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company")
public class CompanyEntity {
    @Id
    @Column(name = "company_code")
    private Integer companyCode;

    @Column(name = "company_name")
    private String companyName;
}
