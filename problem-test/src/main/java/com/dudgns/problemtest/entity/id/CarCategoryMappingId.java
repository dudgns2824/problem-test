package com.dudgns.problemtest.entity.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarCategoryMappingId implements Serializable {
    @Column(name = "car_idx", nullable = false, updatable = false)
    private Long carIdx;
    @Column(name = "category_type", nullable = false, updatable = false)
    private Integer categoryType;
}
