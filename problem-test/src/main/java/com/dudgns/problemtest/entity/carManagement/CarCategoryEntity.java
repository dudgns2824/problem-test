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
    private Integer categoryType;

    @Column
    private String categoryName;
}
