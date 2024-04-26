package com.dudgns.problemtest.controller.carManagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "자동차 조회 dto 목록")
public class ResponseCarManagementListDto {
    @Schema(description = "자동차 조회 dto list")
    private List<ResponseCarManagementDto> carManagementDtoList;
}
