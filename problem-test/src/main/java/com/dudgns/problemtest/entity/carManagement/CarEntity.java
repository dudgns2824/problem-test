package com.dudgns.problemtest.entity.carManagement;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_idx", insertable = false, updatable = false)
    private List<CarCategoryMappingEntity> carCategoryMappingEntityList = new ArrayList<>();

    @Column(name = "company_code", insertable = true, updatable = true)
    private Long companyCode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_code", referencedColumnName = "company_code", insertable = false, updatable = false)
    private CompanyEntity companyEntity;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "created_year")
    private Integer createdYear;

    @Column(name = "rental_yn")
    private Boolean rentalYn;
}
