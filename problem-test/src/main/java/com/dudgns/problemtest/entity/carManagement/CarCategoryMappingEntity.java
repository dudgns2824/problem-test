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
@Table(name = "car_category_mapping")
public class CarCategoryMappingEntity {
    @Id
    @Column(name = "car_idx")
    private Long carIdx;
    @Column(name = "category_type")
    private Long categoryType;
    @Column(name = "category_name")
    private String categoryName;
}
