package com.example.EmployeeManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetInventoryReportDTO {

    private String branchName;
    private String type;
    private String serialNumber;
    private String modelName;
    private Date manufacturingDate;
    private String specification;
    private Date addedDate;

}
