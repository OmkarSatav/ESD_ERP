package com.academic.erp_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude=SecurityAutoConfiguration.class)
public class ErpBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErpBackendApplication.class, args);
    }

}
