package com.example.EmployeeManagementSystem.Model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class DepartmentModel {

    private Long id;
    private String company;

    private String departmentName;

    private String departmentCode;

}
