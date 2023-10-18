package com.example.EmployeeManagementSystem.Controller;

import com.example.EmployeeManagementSystem.Service.AssetInventoryReportService;
import com.example.EmployeeManagementSystem.dto.AssetInventoryReportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/asset-inventory-report")
public class AssetInventoryReportController {

    @Autowired
    private AssetInventoryReportService assetInventoryReportService;

    @GetMapping("/generate")
    public ResponseEntity<List<AssetInventoryReportDTO>> generateAssetInventoryReport(
            @RequestParam(required = false) String branch,
            @RequestParam(required = false) String assetType,
            @RequestParam(required = false) Boolean assetAssign) {
        List<AssetInventoryReportDTO> reportData = assetInventoryReportService.generateAssetInventoryReport(branch, assetType, assetAssign);
        return ResponseEntity.ok(reportData);
    }
}





