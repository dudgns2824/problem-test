package com.dudgns.problemtest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "기본 응답 포맷")
public class BaseRepsonseDto<T>{
    private Integer statusCode;
    private String status;
    private T data;
}
