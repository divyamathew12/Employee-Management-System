package com.example.EmployeeManagementSystem.Repository;


import com.example.EmployeeManagementSystem.Entity.CompanyDeductions;
import com.example.EmployeeManagementSystem.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeductionRepository extends JpaRepository <CompanyDeductions, Long> {

}
