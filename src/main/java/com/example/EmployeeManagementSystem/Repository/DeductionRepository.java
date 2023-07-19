package com.example.EmployeeManagementSystem.Repository;


import com.example.EmployeeManagementSystem.Entity.CompanyDeductions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeductionRepository extends JpaRepository <CompanyDeductions, Long> {
}
