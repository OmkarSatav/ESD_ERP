package com.academic.erp_backend.controller;

import com.academic.erp_backend.dto.LoginRequestObj;
import com.academic.erp_backend.dto.LoginResponseObj;
import com.academic.erp_backend.dto.RequestPasswordObj;
import com.academic.erp_backend.entity.Employees;
import com.academic.erp_backend.service.EmployeeService;
import com.academic.erp_backend.service.JWTService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/auth")
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;
    private final JWTService jwtService;

    public EmployeeController(EmployeeService employeeService, JWTService jwtService) {
        this.employeeService = employeeService;
        this.jwtService = jwtService;
    }

    @PutMapping("/update-password")
    public String updatePassword(@RequestBody RequestPasswordObj passwordObj) {
        employeeService.updateEmployeePasswords(passwordObj);
        return "Password updated successfully";
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employees>> allEmployees() {
        return ResponseEntity.ok(employeeService.allEmployees());
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseObj> loginEmployee(@RequestBody LoginRequestObj loginRequestObj) {

        Employees authenticateEmployee = employeeService.authenticate(loginRequestObj);
        String jwtToken =jwtService.generateToken(authenticateEmployee);

        LoginResponseObj loginResponse = new LoginResponseObj()
                .setToken(jwtToken)
                .setExpiry_time(jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }

}