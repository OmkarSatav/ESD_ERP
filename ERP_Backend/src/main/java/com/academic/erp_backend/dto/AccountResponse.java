package com.academic.erp_backend.dto;

import com.academic.erp_backend.entity.Departments;
import com.academic.erp_backend.entity.EmployeeSalary;
import jakarta.persistence.NamedEntityGraph;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class AccountResponse {
    private int employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private String title;
    private String photograph_path;
    private Departments department;
    private EmployeeSalary employeeSalary;

    public AccountResponse(EmployeeSalary employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    @Override
    public String toString() {
        return "AccountResponse{" +
                "employee_id=" + employee_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", title='" + title + '\'' +
                ", photograph_path='" + photograph_path + '\'' +
                ", department=" + department +
                ", employeeSalary=" + employeeSalary +
                '}';
    }
}