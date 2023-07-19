package com.example.EmployeeManagementSystem.Model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class SalaryModel {
    private Long id;
    private String employee;
    private String month;
    private String year;
    private String basic;
    private String dearnessAllowance;
    private String houseRentAllowance;
    private  String otherAdditions;
    private String deductions;
    private String netPay;
}
