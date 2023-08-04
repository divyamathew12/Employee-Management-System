package com.example.EmployeeManagementSystem.Repository;

import com.example.EmployeeManagementSystem.Entity.EmployeeSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepository extends JpaRepository<EmployeeSalary, Long> {
    List<EmployeeSalary> findByEmployeeId(Long employeeId);


}
