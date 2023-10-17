package com.example.EmployeeManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveReportDTO {

    private String employeeName;
    private Date fromDate;
    private Date toDate;
    private String branchName;
    private String status;

}
