package com.example.EmployeeManagementSystem.Controller;

import com.example.EmployeeManagementSystem.Entity.CompanyDeductions;
import com.example.EmployeeManagementSystem.Service.DeductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/deductions")
public class DeductionController {

    private final DeductionService deductionService;

    @Autowired
    public DeductionController(DeductionService deductionService) {
        this.deductionService = deductionService;
    }

    @GetMapping("/fixed")
    public  CompanyDeductions getFixedDeduction(){
        return deductionService.getFixedDeduction();
    }
    @GetMapping
    public List<CompanyDeductions> getAllCompanyDeductions() {
        return deductionService.getAllCompanyDeductions();
    }

    @GetMapping("/{id}")
    public Optional<CompanyDeductions> getCompanyDeductionById(@PathVariable Long id) {
        return deductionService.getCompanyDeductionById(id);
    }
    @PostMapping
    public CompanyDeductions createDeduction(@RequestBody CompanyDeductions companyDeductions) {
        return deductionService.createCompanyDeduction(companyDeductions);
    }

    @PutMapping("/{id}")
    public CompanyDeductions updateCompanyDeduction(@PathVariable Long id, @RequestBody CompanyDeductions companyDeductions) {
        return deductionService.updateCompanyDeduction(id, companyDeductions);
    }

    @DeleteMapping("/{id}")
    public void deleteCompanyDeductions(@PathVariable Long id) {
        deductionService.deleteCompanyDeductions(id);
    }
}


