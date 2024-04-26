package com.dudgns.problemtest.controller.carManagement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ResponseCarManagementDto {
    @Schema(description = "자동차 카테고리")
    private String carCategory;
    @Schema(description = "제조사")
    private String company;
    @Schema(description = "생산 년도")
    private String createdYear;
}
