package com.problemTest.auth.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class RequestCreateUserDto {
    private String ticketUuid;
    private String email;
    private String userId;
    private String password;
}
