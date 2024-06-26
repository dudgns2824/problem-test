package com.problemTest.auth.mail.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ResponseMailVerifyDto {
    private String email;
    private Boolean success;
    private String ticket;
}
