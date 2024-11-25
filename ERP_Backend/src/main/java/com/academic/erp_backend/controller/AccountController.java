package com.academic.erp_backend.controller;

import com.academic.erp_backend.dto.AccountResponse;
import com.academic.erp_backend.entity.Employees;
import com.academic.erp_backend.entity.EmployeeSalary;
import com.academic.erp_backend.dto.ApiUtils;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import com.academic.erp_backend.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RequestMapping("/account")
@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/amount")
    public ResponseEntity<ApiUtils<List<AccountResponse>>> getEmployeeDetailsByCredential() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Employees employee = (Employees) auth.getPrincipal();
        try {
            if (employee.getDepartment().getDepartment_id().equals(2)) {
                List<AccountResponse> allEmployeeDetails = accountService.getAllEmployeeDetails();

                ApiUtils<List<AccountResponse>> response = ApiUtils.<List<AccountResponse>>builder()
                        .success(true)
                        .message("All employee details fetched successfully")
                        .data(allEmployeeDetails)
                        .statusCode(HttpStatus.OK.value())
                        .build();

                return ResponseEntity.ok(response);
            } else {
                // Fetch the employee's own details
                Optional<EmployeeSalary> salary = accountService.getAccountDetails(employee.getEmployee_id());
                System.out.println(salary);
                if (salary.isPresent()) {
                    AccountResponse details = AccountResponse.builder()
                            .employee_id(employee.getEmployee_id())
                            .first_name(employee.getFirst_name())
                            .last_name(employee.getLast_name())
                            .email(employee.getEmail())
                            .title(employee.getTitle())
                            .photograph_path(employee.getPhotograph_path())
                            .department(employee.getDepartment())
                            .employeeSalary(salary.get())
                            .build();

                    ApiUtils<List<AccountResponse>> response = ApiUtils.<List<AccountResponse>>builder()
                            .success(true)
                            .message("Employees details fetched successfully")
                            .data(List.of(details))
                            .statusCode(HttpStatus.OK.value())
                            .build();

                    return ResponseEntity.ok(response);
                } else {
                    ApiUtils<List<AccountResponse>> errorResponse = ApiUtils.<List<AccountResponse>>builder()
                            .success(false)
                            .message("Employees salary details not found")
                            .data(null)
                            .statusCode(HttpStatus.NOT_FOUND.value())
                            .build();

                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
                }
            }
        } catch (Exception ex) {
            ApiUtils<List<AccountResponse>> errorResponse = ApiUtils.<List<AccountResponse>>builder()
                    .success(false)
                    .message("An error occurred while fetching employee details")
                    .errors(ex.getMessage())
                    .data(null)
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PutMapping("/update-amount")
    public ResponseEntity<ApiUtils<Void>> updateAmount(@RequestBody @Valid List<EmployeeSalary> employeeSalaries) {
        try {
            // Retrieve the currently authenticated employee
            Employees currentEmployee = (Employees) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            // Update the salaries using the service layer
            accountService.updateAmount(employeeSalaries, currentEmployee);

            // Build the success response
            ApiUtils<Void> response = ApiUtils.<Void>builder()
                    .success(true)
                    .message("Salaries updated successfully")
                    .data(null)
                    .statusCode(HttpStatus.OK.value())
                    .build();

            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            // Handle exceptions and build the error response
            ApiUtils<Void> errorResponse = ApiUtils.<Void>builder()
                    .success(false)
                    .message("Failed to update salaries")
                    .errors(ex.getMessage())
                    .data(null)
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

}