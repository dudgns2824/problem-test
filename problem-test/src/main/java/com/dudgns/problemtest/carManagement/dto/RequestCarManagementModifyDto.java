package com.dudgns.problemtest.carManagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "자동차 수정 dto")
public class RequestCarManagementModifyDto {
    @Schema(description = "자동차 인덱스 번호")
    @JsonProperty(value = "car_idx")
    private Long carIdx;
    @Schema(description = "카테고리 타입 목록")
    @JsonProperty(value = "category_type_list")
    private List<Integer> categoryTypeList;
    @Schema(description = "제조사 코드 번호")
    @JsonProperty(value = "company_code")
    private Long companyCode;
    @Schema(description = "모델 명")
    @JsonProperty(value = "model_name")
    private String modelName;
    @Schema(description = "생산 년도")
    @JsonProperty(value = "created_year")
    private Integer createdYear;
    @Schema(description = "대여 가능 여부")
    @JsonProperty(value = "rental_yn")
    private Boolean rentalYn;
}
