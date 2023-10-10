package com.example.EmployeeManagementSystem.Controller;

import com.example.EmployeeManagementSystem.Entity.EmployeeSalary;
import com.example.EmployeeManagementSystem.Entity.LeaveApplication;
import com.example.EmployeeManagementSystem.Entity.SalaryAdvance;
import com.example.EmployeeManagementSystem.Service.SalaryAdvanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/salary-advance")
public class SalaryAdvanceController {
    @Autowired
    SalaryAdvanceService salaryAdvanceService;

    @PostMapping("/apply")
    public ResponseEntity<SalaryAdvance> applySalaryAdvance(
            @RequestParam int month,
            @RequestParam int year,
            @RequestParam double advanceAmount) {
        SalaryAdvance salaryAdvance = salaryAdvanceService.applySalaryAdvance( month, year, advanceAmount);
        return ResponseEntity.ok(salaryAdvance);
    }

    @GetMapping
    public List<SalaryAdvance> getAllSalaryAdvances() {
        return salaryAdvanceService.getAllSalaryAdvances();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaryAdvance> getSalaryAdvanceById(@PathVariable Long id) {
        SalaryAdvance salaryAdvance = salaryAdvanceService.getSalaryAdvanceById(id);
        if (salaryAdvance == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(salaryAdvance);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalaryAdvance> updateSalaryAdvance(@PathVariable Long id, @RequestBody SalaryAdvance salaryAdvance) {
        SalaryAdvance updatedSalaryAdvance = salaryAdvanceService.updateSalaryAdvance(id, salaryAdvance);
        if (updatedSalaryAdvance == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedSalaryAdvance);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalaryAdvance(@PathVariable Long id) {
        if (salaryAdvanceService.deleteSalaryAdvance(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}



