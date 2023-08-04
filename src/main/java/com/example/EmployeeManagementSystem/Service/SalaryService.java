package com.example.EmployeeManagementSystem.Service;

import com.example.EmployeeManagementSystem.Entity.CompanyDeductions;
import com.example.EmployeeManagementSystem.Entity.Employee;
import com.example.EmployeeManagementSystem.Entity.EmployeeSalary;
import com.example.EmployeeManagementSystem.Entity.Payment;
import com.example.EmployeeManagementSystem.Repository.DeductionRepository;
import com.example.EmployeeManagementSystem.Repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SalaryService {
    private final SalaryRepository salaryRepository;
    private CompanyDeductions companyDeductions;

    private EmployeeService employeeService;

    @Autowired
    public SalaryService(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    @Autowired
    private DeductionRepository deductionRepository;

    public List<EmployeeSalary> getAllSalaries() {
        return salaryRepository.findAll();
    }

    public Optional<EmployeeSalary> getSalaryById(Long id) {
        return salaryRepository.findById(id);
    }

    public List<EmployeeSalary> getByEmployeeId(Long employeeId){return salaryRepository.findByEmployeeId(employeeId); }

    public EmployeeSalary createSalary(EmployeeSalary salary) {
        return salaryRepository.save(salary);
    }

    public EmployeeSalary grossPay(EmployeeSalary employeeSalary) {
        double basic = employeeSalary.getBasic();
        double dearnessAllowance = employeeSalary.getDearnessAllowance();
        double houseRentAllowance = employeeSalary.getHouseRentAllowance();
        double otherAdditions = employeeSalary.getOtherAdditions();

        double grossPay = basic + dearnessAllowance + houseRentAllowance + otherAdditions;

        employeeSalary.setGrossPay(grossPay);

        return salaryRepository.save(employeeSalary);

    }
    public EmployeeSalary updateSalary(Long id, EmployeeSalary updatedSalary) {
        Optional<EmployeeSalary> existingSalary = salaryRepository.findById(id);
        if (existingSalary.isPresent()) {
            EmployeeSalary salary = existingSalary.get();
            salary.setBasic(updatedSalary.getBasic());
            salary.setDearnessAllowance(updatedSalary.getDearnessAllowance());
            salary.setHouseRentAllowance(updatedSalary.getHouseRentAllowance());
            salary.setGrossPay(updatedSalary.getGrossPay());

            return salaryRepository.save(salary);
        }
        return null;
    }

    public void deleteSalary(Long id) {
        salaryRepository.deleteById(id);
    }
}




