package com.academic.erp_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestPasswordObj {

    private String password;

    @Override
    public String toString() {
        return "RequestPasswordObj{" +
                "password='" + password + '\'' +
                '}';
    }
}