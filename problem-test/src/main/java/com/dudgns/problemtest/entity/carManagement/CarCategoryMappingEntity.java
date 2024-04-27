package com.dudgns.problemtest.entity.carManagement;

import com.dudgns.problemtest.entity.id.CarCategoryMappingId;
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
@Table(name = "car_category_mapping")
public class CarCategoryMappingEntity {
    @EmbeddedId
    private CarCategoryMappingId carCategoryMappingId;
    @Column(name = "category_name")
    private String categoryName;
}
