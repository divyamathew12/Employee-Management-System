package com.example.EmployeeManagementSystem.Controller;

import com.example.EmployeeManagementSystem.Entity.EmployeeSalary;
import com.example.EmployeeManagementSystem.Entity.Payment;
import com.example.EmployeeManagementSystem.Service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/salaries")
public class SalaryController {
    private final SalaryService salaryService;
    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }
    @GetMapping
    public List<EmployeeSalary> getAllSalaries() {
        return salaryService.getAllSalaries();
    }
    @GetMapping("/{id}")
    public Optional<EmployeeSalary> getSalaryById(@PathVariable Long id) {
        return salaryService.getSalaryById(id);
    }

    @GetMapping("/{employeeId}")
    public  List<EmployeeSalary> getByEmployeeId(@RequestParam Long employeeId){
        return salaryService.getByEmployeeId(employeeId);
    }
    @PostMapping
    public EmployeeSalary createSalary(@RequestBody EmployeeSalary salary) {
        return salaryService.createSalary(salary);
    }
    @PostMapping ("/grossPay")
    public EmployeeSalary grossPay(@RequestBody EmployeeSalary employeeSalary){
        return salaryService.grossPay(employeeSalary);
    }

    @PutMapping("/{id}")
    public EmployeeSalary updateSalary(@PathVariable Long id, @RequestBody EmployeeSalary salary) {
        return salaryService.updateSalary(id, salary);
    }

    @DeleteMapping("/{id}")
    public void deleteSalary(@PathVariable Long id) {
        salaryService.deleteSalary(id);
    }

}
