package com.example.EmployeeManagementSystem.Service;


import com.example.EmployeeManagementSystem.Entity.AssetAssign;
import com.example.EmployeeManagementSystem.Repository.AssetAssignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetAssignService {

    @Autowired
    AssetAssignRepository assetAssignRepository;

        public List<AssetAssign> getAllAssetAssignments() {
            return assetAssignRepository.findAll();
        }

        public AssetAssign getAssetAssignmentById(Long id) {
            return assetAssignRepository.findById(id).orElse(null);
        }

        public AssetAssign assignAssetToEmployee(AssetAssign assetAssign) {
            assetAssign.setReturnDate(null);
            assetAssign.setReturnRemarks(null);
            List<AssetAssign> existingAssignments = assetAssignRepository.findByAssetAndReturnDateIsNull(assetAssign.getAsset());

            if (!existingAssignments.isEmpty()) {
                throw new RuntimeException("Asset is already assigned to another employee.");
            }


            return assetAssignRepository.save(assetAssign);
        }

        public AssetAssign updateAssetAssignment(AssetAssign assetAssign) {

            AssetAssign existingAssignment = assetAssignRepository.findById(assetAssign.getId())
                    .orElseThrow(() -> new RuntimeException("Asset assignment not found."));

            existingAssignment.setEmployee(assetAssign.getEmployee());
            existingAssignment.setAssignDate(assetAssign.getAssignDate());
            existingAssignment.setAssignRemarks(assetAssign.getAssignRemarks());

            if(assetAssign.getReturnDate()!=null) {
                existingAssignment.setReturnDate(assetAssign.getReturnDate());
            }
            existingAssignment.setReturnRemarks(assetAssign.getReturnRemarks());

            return assetAssignRepository.save(existingAssignment);
        }

        public void deleteAssetAssignment(Long id) {
            assetAssignRepository.deleteById(id);
        }
    }






