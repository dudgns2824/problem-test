package com.problemTest.auth.exception;

public class LoginFailedException extends RuntimeException {
    public LoginFailedException() {
        super("아이디와 패스워드를 다시 한번 확인 해 주세요.");
    }
}
