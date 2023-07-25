package com.example.EmployeeManagementSystem.Model;

import lombok.Data;

@Data
public class DeductionModel {

    private Long id;

    private String company;

    private double providentFund;

    private double employeeStateInsurance;

}
