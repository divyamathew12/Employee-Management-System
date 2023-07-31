package com.example.EmployeeManagementSystem.Repository;

import com.example.EmployeeManagementSystem.Entity.EmployeeSalary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaryRepository extends JpaRepository<EmployeeSalary, Long> {
    List<EmployeeSalary> findByMonthAndYearAndEmployeeId(String month, int year, Long id);

}
