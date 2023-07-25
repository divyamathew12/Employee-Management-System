package com.example.EmployeeManagementSystem.Model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class DesignationModel {

    private Long id;

    private String company;

    private String designationName;

    private String designationCode;
}
