package com.example.EmployeeManagementSystem.Service;

import com.example.EmployeeManagementSystem.Entity.CompanyDeductions;
import com.example.EmployeeManagementSystem.Entity.EmployeeSalary;
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

    public EmployeeSalary createSalary(EmployeeSalary salary) {
        return salaryRepository.save(salary);
    }

    public EmployeeSalary saveSalary(EmployeeSalary salary) {

        if (this.companyDeductions == null) {
            this.companyDeductions = new CompanyDeductions();

            CompanyDeductions deductions = salary.getCompanyDeductions();
            double basic = salary.getBasic();
            double dearnessAllowance = salary.getDearnessAllowance();
            double houseRentAllowance = salary.getHouseRentAllowance();
            double otherAdditions = salary.getOtherAdditions();
            double providentFund = this.companyDeductions.getProvidentFund();
            double employeeStateInsurance = this.companyDeductions.getEmployeeStateInsurance();

            double totalSalary = basic + dearnessAllowance + houseRentAllowance + otherAdditions;

            double totalDeduction = totalSalary * (providentFund + employeeStateInsurance) / 100;

            double netSalary = totalSalary - totalDeduction;

            deductions.setProvidentFund(providentFund);
            deductions.setEmployeeStateInsurance(employeeStateInsurance);
            salary.setDearnessAllowance(dearnessAllowance);
            salary.setHouseRentAllowance(houseRentAllowance);
            salary.setOtherAdditions(otherAdditions);
            salary.setTotalSalary(totalSalary);
            salary.setTotalDeduction(totalDeduction);
            salary.setNetSalary(netSalary);

            return salaryRepository.save(salary);

        } else {
            throw new IllegalStateException("Company deductions are not set for this employee.");
        }
    }

    public EmployeeSalary updateSalary(Long id, EmployeeSalary updatedSalary) {
        Optional<EmployeeSalary> existingSalary = salaryRepository.findById(id);
        if (existingSalary.isPresent()) {
            EmployeeSalary salary = existingSalary.get();
            salary.setMonth(updatedSalary.getMonth());
            salary.setYear(updatedSalary.getYear());
            salary.setBasic(updatedSalary.getBasic());
            salary.setDearnessAllowance(updatedSalary.getDearnessAllowance());
            salary.setHouseRentAllowance(updatedSalary.getHouseRentAllowance());
            salary.setOtherAdditions(updatedSalary.getOtherAdditions());
            salary.setNetPay(updatedSalary.getNetPay());

            return salaryRepository.save(salary);
        }
        return null;
    }
    public List<EmployeeSalary> getSalaryByMonthAndYearAndEmployeeId(String month, int year, Long id){
    return salaryRepository.findByMonthAndYearAndEmployeeId(month, year, id);
}
    public void deleteSalary(Long id) {
        salaryRepository.deleteById(id);
    }

    public List<EmployeeSalary> searchSalaries(String employeeName, String email) {
        return null;
    }

}




