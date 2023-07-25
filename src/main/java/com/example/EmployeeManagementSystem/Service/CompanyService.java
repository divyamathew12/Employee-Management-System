package com.example.EmployeeManagementSystem.Service;

import com.example.EmployeeManagementSystem.Entity.Company;
import com.example.EmployeeManagementSystem.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    @Autowired
    public CompanyService (CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Optional<Company> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    public Company createCompany (Company company) {
        return companyRepository.save(company);
    }

    public Company updateCompany(Long id, Company updatedCompany) {
        Optional<Company> existingCompany = companyRepository.findById(id);
        if (existingCompany.isPresent()) {
            Company company = existingCompany.get();
            company.setCompanyName(updatedCompany.getCompanyName());
            company.setCompanyCode(updatedCompany.getCompanyCode());
            return companyRepository.save(company);
        }
        return null;
    }
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}

