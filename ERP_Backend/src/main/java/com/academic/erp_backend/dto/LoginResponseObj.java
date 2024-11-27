package com.academic.erp_backend.dto;

import lombok.Getter;

@Getter
public class LoginResponseObj {

    private String token;
    private Long expiry_time;

    public LoginResponseObj setToken(String token) {
        this.token = token;
        return this;
    }

    public LoginResponseObj setExpiry_time(Long expiry_time) {
        this.expiry_time = expiry_time;
        return this;
    }

    @Override
    public String toString() {
        return "LoginResponseObj{" +
                "token='" + token + '\'' +
                ", expiry_time=" + expiry_time +
                '}';
    }
}