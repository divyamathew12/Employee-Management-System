package com.example.EmployeeManagementSystem.Controller;


import com.example.EmployeeManagementSystem.Service.LeaveReportService;
import com.example.EmployeeManagementSystem.dto.LeaveReportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/leave-report")
public class LeaveReportController {
     @Autowired
     LeaveReportService leaveReportService;

    @GetMapping("/generate")
    public ResponseEntity<List<LeaveReportDTO>> generateLeaveReport(
            @RequestParam(name = "employeeName", required = false) String employeeName,
            @RequestParam(name = "fromDate",required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
            @RequestParam(name = "toDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate,
            @RequestParam(name = "branch", required = false) String branch,
            @RequestParam(name = "status", required = false) String status) {
        List<LeaveReportDTO> reportData = leaveReportService.generateLeaveReport(
                employeeName, fromDate, toDate, branch ,status);
        return ResponseEntity.ok(reportData);
    }
}


