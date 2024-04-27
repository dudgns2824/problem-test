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

    @OneToMany
    @JoinColumn(name = "car_idx")
    private List<CarCategoryMappingEntity> carCategoryEntityList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "company_idx")
    private CompanyEntity companyEntity;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "created_year")
    private String createdYear;
}
