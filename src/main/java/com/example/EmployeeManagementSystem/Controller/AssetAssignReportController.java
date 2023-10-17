package com.example.EmployeeManagementSystem.Controller;

import com.example.EmployeeManagementSystem.Service.AssetAssignReportService;
import com.example.EmployeeManagementSystem.dto.AssetAssignReportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/asset-assign-report")
public class AssetAssignReportController {

    @Autowired
    private AssetAssignReportService assetAssignReportService;

    @GetMapping("/generate")
    public ResponseEntity<List<AssetAssignReportDTO>> generateAssetAssignReport(
            @RequestParam(required = false) String employeeName,
            @RequestParam(required = false) String branch,
            @RequestParam(required = false) String assetType,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date assignedDateFrom,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date assignedDateTo,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date returnedDateFrom,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date returnedDateTo,
            @RequestParam(required = false) boolean assetAssign) {
        List<AssetAssignReportDTO> reportData = assetAssignReportService.generateAssetAssignReport(
                employeeName, branch, assetType, assignedDateFrom, assignedDateTo, returnedDateFrom, returnedDateTo, assetAssign);
        return ResponseEntity.ok(reportData);
    }
}
