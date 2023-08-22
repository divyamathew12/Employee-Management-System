package com.example.EmployeeManagementSystem.Model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class EmployeeModel {

    private Long id;

    private String employeeName;

    private String branch;

    private String department;

    private String designation;

    private String mobile;

    private String email;

    private String bloodGroup;
}
