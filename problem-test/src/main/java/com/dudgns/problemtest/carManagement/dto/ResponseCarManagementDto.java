package com.dudgns.problemtest.carManagement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@Schema(description = "자동차 정보 응답 dto")
public class ResponseCarManagementDto {
    @Schema(description = "모델 명")
    private String modelName;
    @Schema(description = "자동차 카테고리")
    private List<String> carCategory;
    @Schema(description = "제조사")
    private String company;
    @Schema(description = "생산 년도")
    private Integer createdYear;
}
