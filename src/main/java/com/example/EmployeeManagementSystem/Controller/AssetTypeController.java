package com.example.EmployeeManagementSystem.Controller;

import com.example.EmployeeManagementSystem.Entity.AssetType;
import com.example.EmployeeManagementSystem.Service.AssetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assetType")
public class AssetTypeController {

    @Autowired
    private AssetTypeService assetTypeService;

    @PostMapping
    public ResponseEntity<AssetType> createAssetType(@RequestBody AssetType assetType) {
        AssetType createdAssetType = assetTypeService.createAssetType(assetType);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAssetType);
    }

    @GetMapping
    public ResponseEntity<List<AssetType>> getAllAssetTypes() {
        List<AssetType> assetTypes = assetTypeService.getAllAssetTypes();
        return ResponseEntity.ok(assetTypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssetType> getAssetTypeById(@PathVariable Long id) {
        AssetType assetType = assetTypeService.getAssetTypeById(id);
        if (assetType == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(assetType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssetType> updateAssetType(@PathVariable Long id, @RequestBody AssetType assetType) {
        AssetType updatedAssetType = assetTypeService.updateAssetType(id, assetType);
        if (updatedAssetType == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedAssetType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssetType(@PathVariable Long id) {
        if (assetTypeService.deleteAssetType(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
