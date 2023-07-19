package com.example.EmployeeManagementSystem.Model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class BranchModel {

    private Long id;

    private String branchName;

    private String branchCode;

    private Long companyId;

}


