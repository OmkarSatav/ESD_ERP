package com.academic.erp_backend.service;

import com.academic.erp_backend.dto.AccountResponse;
import com.academic.erp_backend.entity.Employees;
import com.academic.erp_backend.entity.EmployeeSalary;
import com.academic.erp_backend.repo.AccountRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private final AccountRepo accountRepo;

    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    public Optional<EmployeeSalary> getAccountDetails(Integer id) {
        return accountRepo.findById(id);
    }

    public List<AccountResponse> getAllEmployeeDetails() {
        return accountRepo.findAllEmployeeDetails();
    }

    public String updateAmount(List<EmployeeSalary> employeeSalary, Employees currEmployee) {

        List<EmployeeSalary> empSalaryList = accountRepo.getAllEmployeeSalary();

        Map<Integer, EmployeeSalary> newSalaryMap = employeeSalary.stream()
                .filter(salary -> salary.getEmployee_id() != currEmployee.getEmployee_id())
                .collect(Collectors.toMap(EmployeeSalary::getEmployee_id, salary -> salary));

        // Update the amounts in the existing salary list
        empSalaryList.forEach(existingSalary -> {
            if (newSalaryMap.containsKey(existingSalary.getEmployee_id())) {
                EmployeeSalary newSalary = newSalaryMap.get(existingSalary.getEmployee_id());
                existingSalary.setAmount(existingSalary.getAmount() + newSalary.getAmount());
            }
        });

        accountRepo.saveAll(empSalaryList);
        return "success!";

    }
}