package com.academic.erp_backend.service;

import com.academic.erp_backend.dto.LoginRequestObj;
import com.academic.erp_backend.dto.RequestPasswordObj;
import com.academic.erp_backend.repo.EmployeeRepo;
import com.academic.erp_backend.entity.Employees;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public EmployeeService(EmployeeRepo employeeRepo, BCryptPasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.employeeRepo = employeeRepo;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public void updateEmployeePasswords(RequestPasswordObj passwordObj) {
        employeeRepo.updatePassword(passwordEncoder.encode(passwordObj.getPassword()));
    }


    public List<Employees> allEmployees() {
        return employeeRepo.findAll();
    }

    public Employees authenticate(LoginRequestObj loginRequestObj) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestObj.getEmail(),
                        loginRequestObj.getPassword()
                )
        );

        if (authentication.isAuthenticated()) {
            return employeeRepo.findByEmail(loginRequestObj.getEmail())
                    .orElseThrow(() -> new RuntimeException("Employees not found"));
        } else {
            throw new RuntimeException("Authentication failed");
        }
    }
}