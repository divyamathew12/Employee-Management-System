package com.example.EmployeeManagementSystem.Service;

import com.example.EmployeeManagementSystem.Entity.Asset;
import com.example.EmployeeManagementSystem.Repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    public Asset createAsset (Asset asset){
        asset.setSerialNumber(asset.getSerialNumber());
        asset.setModelName(asset.getModelName());
        asset.setManufacturingDate(asset.getManufacturingDate());
        asset.setSpecification(asset.getSpecification());
        asset.setAddedDate(asset.getAddedDate());

        return assetRepository.save(asset);

    }

    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    public Asset getAssetById(Long id) {
        return assetRepository.findById(id).orElse(null);
    }

    public Asset updateAsset(Long id, Asset asset) {
        Asset existingAsset = assetRepository.findById(id).orElse(null);

        if (asset != null) {

            existingAsset.setSerialNumber(asset.getSerialNumber());
            existingAsset.setModelName(asset.getModelName());
            existingAsset.setManufacturingDate(asset.getManufacturingDate());
            existingAsset.setSpecification(asset.getSpecification());
            asset.setAddedDate(asset.getAddedDate());

            return assetRepository.save(asset);
        }
        return null;
    }

    public boolean deleteAsset(Long id) {
        Asset existingAsset = assetRepository.findById(id).orElse(null);
        if (existingAsset != null) {
            assetRepository.delete(existingAsset);
            return true;
        }
        return false;
    }
}



