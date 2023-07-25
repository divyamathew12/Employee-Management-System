package com.example.EmployeeManagementSystem.Model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CompanyModel {

    private Long id;

    private String companyName;

    private String companyCode;

}

