package com.example.EmployeeManagementSystem.Controller;

import com.example.EmployeeManagementSystem.Entity.AssetAssign;
import com.example.EmployeeManagementSystem.Service.AssetAssignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assetAssign")
public class AssetAssignController {

    @Autowired
    AssetAssignService assetAssignService;

        @GetMapping("/all")
        public ResponseEntity<List<AssetAssign>> getAllAssetAssignments() {
            List<AssetAssign> assetAssignments = assetAssignService.getAllAssetAssignments();
            return ResponseEntity.ok(assetAssignments);
        }

        @GetMapping("/{id}")
        public ResponseEntity<AssetAssign> getAssetAssignmentById(@PathVariable Long id) {
            AssetAssign assetAssignment = assetAssignService.getAssetAssignmentById(id);
            if (assetAssignment != null) {
                return ResponseEntity.ok(assetAssignment);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @PostMapping("/assign")
        public ResponseEntity<?> assignAsset(@RequestBody AssetAssign assetAssign) {
            try {
                AssetAssign assignedAsset = assetAssignService.assignAssetToEmployee(assetAssign);
                return ResponseEntity.ok("Asset assigned successfully with ID: " + assignedAsset.getId());
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PutMapping("/{id}")
        public ResponseEntity<?> updateAssetAssignment(@RequestBody AssetAssign assetAssign) {
            try {
                AssetAssign updatedAsset = assetAssignService.updateAssetAssignment(assetAssign);
                return ResponseEntity.ok("Asset assignment updated successfully with ID: " + updatedAsset.getId());
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteAssetAssignment(@PathVariable Long id) {
            assetAssignService.deleteAssetAssignment(id);
            return ResponseEntity.ok("Asset assignment deleted successfully.");
        }
    }








