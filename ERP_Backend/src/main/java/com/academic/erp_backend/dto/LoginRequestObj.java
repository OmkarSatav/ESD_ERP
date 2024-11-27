package com.academic.erp_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestObj {
    private String email;
    private String password;

    public LoginRequestObj() {
    }

    public LoginRequestObj(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
