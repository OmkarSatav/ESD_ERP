package com.academic.erp_backend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

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