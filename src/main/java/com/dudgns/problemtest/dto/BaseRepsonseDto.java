package com.dudgns.problemtest.dto;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BaseRepsonseDto<T>{
    private Integer statusCode;
    private String status;
    private Object data;
}
