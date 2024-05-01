package com.dudgns.problemtest.carManagement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
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
