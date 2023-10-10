package com.example.EmployeeManagementSystem.Service;

import com.example.EmployeeManagementSystem.Entity.AssetType;
import com.example.EmployeeManagementSystem.Entity.LeaveApplication;
import com.example.EmployeeManagementSystem.Repository.AssetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetTypeService {

    @Autowired
    private AssetTypeRepository  assetTypeRepository;

    public AssetType createAssetType (AssetType assetType){

        assetType.setType(assetType.getType());
        assetType.setDescription(assetType.getDescription());

        return assetTypeRepository.save(assetType);
    }
    public List<AssetType> getAllAssetTypes() {
        return assetTypeRepository.findAll();
    }

    public AssetType getAssetTypeById(Long id) {
        return assetTypeRepository.findById(id).orElse(null);
    }

    public AssetType updateAssetType(Long id, AssetType assetType) {
        AssetType existingAssetType = assetTypeRepository.findById(id).orElse(null);

        if (assetType != null) {

            existingAssetType.setType(assetType.getType());
            existingAssetType.setDescription(assetType.getDescription());

            return assetTypeRepository.save(assetType);
        }
        return null;
    }

    public boolean deleteAssetType(Long id) {
        AssetType existingAssetType = assetTypeRepository.findById(id).orElse(null);
        if (existingAssetType != null) {
            assetTypeRepository.delete(existingAssetType);
            return true;
        }
        return false;
    }
}


