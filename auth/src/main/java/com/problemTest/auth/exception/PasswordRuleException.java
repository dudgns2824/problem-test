package com.problemTest.auth.exception;

public class PasswordRuleException extends RuntimeException {
    public PasswordRuleException() {
        super("8-16자 영문, 숫자의 조합으로만 입력 가능합니다");
    }

}
