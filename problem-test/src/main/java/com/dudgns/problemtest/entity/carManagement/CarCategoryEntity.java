package com.dudgns.problemtest.entity.carManagement;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car_category")
public class CarCategoryEntity {
    @Id
    @Column(name = "category_type")
    private Integer categoryType;

    @Column(name = "category_name")
    private String categoryName;
}
