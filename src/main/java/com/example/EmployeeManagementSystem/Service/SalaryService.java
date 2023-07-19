package com.example.EmployeeManagementSystem.Service;

import com.example.EmployeeManagementSystem.Entity.Branch;
import com.example.EmployeeManagementSystem.Entity.Department;
import com.example.EmployeeManagementSystem.Entity.Salary;
import com.example.EmployeeManagementSystem.Model.SalaryModel;
import com.example.EmployeeManagementSystem.Repository.BranchRepository;
import com.example.EmployeeManagementSystem.Repository.DepartmentRepository;
import com.example.EmployeeManagementSystem.Repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SalaryService {

    private final SalaryRepository salaryRepository;

    @Autowired
    public SalaryService (SalaryRepository salaryRepository){
        this.salaryRepository = salaryRepository;
    }
    public List<Salary> getAllSalaries() {
        return salaryRepository.findAll();
    }

    public Optional<Salary> getSalariesById(Long id) {
        return salaryRepository.findById(id);
    }

    public Salary createSalary (Salary salary) {
        return salaryRepository.save(salary);
    }

    public Salary updateSalary(Long id, Salary updatedSalary) {
        Optional<Salary> existingSalary = salaryRepository.findById(id);
        if (existingSalary.isPresent()) {
            Salary salary = existingSalary.get();
            salary.setBasic(updatedSalary.getBasic());
            salary.setDearnessAllowance(updatedSalary.getDearnessAllowance());
            salary.setHouseRentAllowance(updatedSalary.getHouseRentAllowance());
            return salaryRepository.save(salary);
        }
        return null;
    }

    public void deleteSalary(Long id) {
        salaryRepository.deleteById(id);
    }
}



