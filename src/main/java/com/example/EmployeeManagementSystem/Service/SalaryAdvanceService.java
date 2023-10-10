package com.example.EmployeeManagementSystem.Service;


import com.example.EmployeeManagementSystem.Entity.EmployeeSalary;
import com.example.EmployeeManagementSystem.Entity.LeaveApplication;
import com.example.EmployeeManagementSystem.Entity.Payment;
import com.example.EmployeeManagementSystem.Entity.SalaryAdvance;
import com.example.EmployeeManagementSystem.Repository.EmployeeRepository;
import com.example.EmployeeManagementSystem.Repository.SalaryAdvanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class SalaryAdvanceService {
    @Autowired
    SalaryAdvanceRepository salaryAdvanceRepository;

    @Autowired
    EmployeeRepository employeeRepository;


    public SalaryAdvance applySalaryAdvance(int month, int year, double advanceAmount) {

        // Employee employee = employeeRepository.getById(employeeId);

        LocalDate today = LocalDate.now();
        if (today.getYear() == year && today.getMonthValue() == month) {
            throw new RuntimeException("Salary for the current month and year has already been processed.");
        }


        Payment payment = new Payment();
        double maxAdvanceAmount = payment.getTotalPay() * 0.5;
        if (advanceAmount > maxAdvanceAmount) {
            throw new RuntimeException("Advance amount exceeds 50% of the total salary.");
        }

        SalaryAdvance salaryAdvance = new SalaryAdvance();
        //salaryAdvance.setEmployee(employee);
        salaryAdvance.setMonth(month);
        salaryAdvance.setYear(year);
        salaryAdvance.setAdvanceAmount(advanceAmount);
        salaryAdvance.setStatus("In-Progress");
        salaryAdvance.setAppliedDate(LocalDate.now());

        if (advanceAmount <= maxAdvanceAmount) {
            salaryAdvance.setStatus("Approved");
            salaryAdvance.setActionDate(LocalDate.now());
            salaryAdvance.setActionRemarks("Automatically approved because the amount is <= 50% of total salary.");
        } else {
            salaryAdvance.setStatus("Rejected");
            salaryAdvance.setActionDate(LocalDate.now());
            salaryAdvance.setActionRemarks("Automatically rejected because the amount exceeds 50% of total salary.");
        }

        return salaryAdvanceRepository.save(salaryAdvance);
    }

    public List<SalaryAdvance> getAllSalaryAdvances() {
        return salaryAdvanceRepository.findAll();
    }

    public SalaryAdvance getSalaryAdvanceById(Long id) {
        return salaryAdvanceRepository.findById(id).orElse(null);
    }

    public SalaryAdvance updateSalaryAdvance(Long id, SalaryAdvance salaryAdvance) {
        SalaryAdvance existingSalaryAdvance = salaryAdvanceRepository.findById(id).orElse(null);

        if (salaryAdvance != null) {

            existingSalaryAdvance.setStatus(salaryAdvance.getStatus());
            existingSalaryAdvance.setActionDate(salaryAdvance.getActionDate());
            existingSalaryAdvance.setActionRemarks(salaryAdvance.getActionRemarks());

            return salaryAdvanceRepository.save(salaryAdvance);
        }
        return null;
    }

    public boolean deleteSalaryAdvance(Long id) {
        SalaryAdvance existingSalaryAdvance = salaryAdvanceRepository.findById(id).orElse(null);
        if (existingSalaryAdvance != null) {
            salaryAdvanceRepository.delete(existingSalaryAdvance);
            return true;
        }
        return false;
    }
}


