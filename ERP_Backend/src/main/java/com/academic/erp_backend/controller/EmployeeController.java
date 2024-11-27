package com.academic.erp_backend.controller;

import com.academic.erp_backend.dto.ApiUtils;
import com.academic.erp_backend.dto.LoginRequestObj;
import com.academic.erp_backend.dto.LoginResponseObj;
import com.academic.erp_backend.dto.RequestPasswordObj;
import com.academic.erp_backend.entity.EmployeeSalary;
import com.academic.erp_backend.entity.Employees;
import com.academic.erp_backend.service.AccountService;
import com.academic.erp_backend.service.EmployeeService;
import com.academic.erp_backend.service.JWTService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<ApiUtils<List<Employees>>> allEmployees() {
        try {
            List<Employees> employees = employeeService.allEmployees();

            ApiUtils<List<Employees>> response = ApiUtils.<List<Employees>>builder()
                    .success(true)
                    .message("Employees fetched successfully")
                    .data(employees)
                    .statusCode(HttpStatus.OK.value())
                    .build();

            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            ApiUtils<List<Employees>> errorResponse = ApiUtils.<List<Employees>>builder()
                    .success(false)
                    .message("Failed to fetch employees")
                    .errors(ex.getMessage())
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        } finally {
            System.out.println("Employees list fetched");
        }
    }


    @PostMapping("/login")
    public ResponseEntity<ApiUtils<LoginResponseObj>> loginEmployee(@RequestBody LoginRequestObj loginRequestObj) {
        try {

            Employees authenticateEmployee = employeeService.authenticate(loginRequestObj);
            String jwtToken =jwtService.generateToken(authenticateEmployee);
    
            LoginResponseObj loginResponse = new LoginResponseObj()
                    .setToken(jwtToken)
                    .setExpiry_time(jwtService.getExpirationTime());


            ApiUtils<LoginResponseObj> response = ApiUtils.<LoginResponseObj>builder()
                    .success(true)
                    .message("Login successful")
                    .data(loginResponse)
                    .statusCode(HttpStatus.OK.value())
                    .build();

            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            // Handle errors and create error response
            ApiUtils<LoginResponseObj> errorResponse = ApiUtils.<LoginResponseObj>builder()
                    .success(false)
                    .message("Login failed")
                    .errors(ex.getMessage())
                    .statusCode(HttpStatus.UNAUTHORIZED.value())
                    .build();

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        } finally {
            System.out.println("Employees logged in");
        }
    }





}