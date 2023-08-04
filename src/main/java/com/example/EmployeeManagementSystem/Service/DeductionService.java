package com.example.EmployeeManagementSystem.Service;
import com.example.EmployeeManagementSystem.Entity.CompanyDeductions;
import com.example.EmployeeManagementSystem.Entity.EmployeeSalary;
import com.example.EmployeeManagementSystem.Repository.DeductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeductionService {
    private final DeductionRepository deductionRepository;
    @Autowired
    public DeductionService (DeductionRepository deductionRepository){
        this.deductionRepository = deductionRepository;
    }
    public List<CompanyDeductions> getAllCompanyDeductions() {
        return deductionRepository.findAll();
    }


    public Optional<CompanyDeductions> getCompanyDeductionById(Long id) {
        return deductionRepository.findById(id);
    }

    public CompanyDeductions createCompanyDeduction (CompanyDeductions companyDeductions) {
        return deductionRepository.save(companyDeductions);
    }
    public CompanyDeductions getFixedDeduction(){
        CompanyDeductions companyDeductions = new CompanyDeductions();
        companyDeductions.setProvidentFund(12.0);
        companyDeductions.setEmployeeStateInsurance(1.57);
        return companyDeductions;
    }

    public CompanyDeductions updateCompanyDeduction(Long id, CompanyDeductions updatedCompanyDeductions) {
        Optional<CompanyDeductions> existingCompanyDeductions = deductionRepository.findById(id);
        if (existingCompanyDeductions.isPresent()) {
            CompanyDeductions companyDeductions = existingCompanyDeductions.get();
            companyDeductions.setProvidentFund(updatedCompanyDeductions.getProvidentFund());
            companyDeductions.setEmployeeStateInsurance(updatedCompanyDeductions.getEmployeeStateInsurance());
            return deductionRepository.save(companyDeductions);
        }
        return null;
    }
    public void deleteCompanyDeductions(Long id) {
        deductionRepository.deleteById(id);
    }
}


