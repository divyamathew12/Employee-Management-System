package com.example.EmployeeManagementSystem.dto;

import com.example.EmployeeManagementSystem.Entity.AssetType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetAssignReportDTO {
    private String type;
    private Long assetId;
    private String serialNumber;
    private String employeeName;
    private Date assignDate;
    private Date returnDate;
    private String assignRemarks;
    private String returnRemarks;

}
