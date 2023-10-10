package com.example.EmployeeManagementSystem.Repository;

import com.example.EmployeeManagementSystem.Entity.SalaryAdvance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryAdvanceRepository extends JpaRepository<SalaryAdvance, Long> {
}
