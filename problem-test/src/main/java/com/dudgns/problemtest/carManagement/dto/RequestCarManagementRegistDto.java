package com.dudgns.problemtest.carManagement.dto;

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
@Schema(description = "자동차 등록 dto")
public class RequestCarManagementRegistDto {
    @Schema(description = "카테고리 타입 목록")
    private List<Integer> categoryTypeList;
    @Schema(description = "제조사 코드 번호")
    private Integer companyCode;
}
