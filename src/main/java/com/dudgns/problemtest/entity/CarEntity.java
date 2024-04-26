package com.dudgns.problemtest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Column
    private String company;

    @Column
    private String modelName;

    /*년도라서 localdate보다 String 으로 처리*/
    @Column
    private String createdYear;
}
