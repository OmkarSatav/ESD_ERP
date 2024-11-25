package com.academic.erp_backend.repo;

import com.academic.erp_backend.dto.AccountResponse;
import com.academic.erp_backend.entity.EmployeeSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository<EmployeeSalary, Integer> {

    @Query("SELECT new com.academic.erp_backend.dto.AccountResponse(" +
            "e.employee_id, e.first_name, e.last_name, e.email, e.title, e.photograph_path, e.department, es) " +
            "FROM Employees e " +
            "LEFT JOIN EmployeeSalary es ON e.employee_id = es.employee_id")
    List<AccountResponse> findAllEmployeeDetails();

    @Query("SELECT es FROM EmployeeSalary es")
    List<EmployeeSalary> getAllEmployeeSalary();
}