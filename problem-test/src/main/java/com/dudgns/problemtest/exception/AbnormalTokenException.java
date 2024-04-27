package com.dudgns.problemtest.exception;

public class AbnormalTokenException extends RuntimeException{
    public AbnormalTokenException() {
        super("올바르지 않은 토큰 입니다.");
    }
}
