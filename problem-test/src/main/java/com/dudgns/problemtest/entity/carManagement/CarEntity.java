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
    @JoinColumn(name = "car_category_idx")
    private List<CarCategoryEntity> carCategoryEntityList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "company_idx")
    private CompanyEntity companyEntity;

    @Column
    private String modelName;

    @Column
    private String createdYear;
}
