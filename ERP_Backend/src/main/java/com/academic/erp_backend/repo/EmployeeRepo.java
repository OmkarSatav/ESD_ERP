package com.academic.erp_backend.repo;

import com.academic.erp_backend.entity.EmployeeSalary;
import com.academic.erp_backend.entity.Employees;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employees, Integer> {

    @Transactional
    @Modifying
    @Query("Update Employees e set e.password = ?1 where e.employee_id between 1 and 12")
    void updatePassword(@Param("password") String password);

    Optional<Employees> findByEmail(String email);

}