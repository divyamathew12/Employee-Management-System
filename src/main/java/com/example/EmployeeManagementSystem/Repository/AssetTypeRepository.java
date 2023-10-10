package com.example.EmployeeManagementSystem.Repository;

import com.example.EmployeeManagementSystem.Entity.AssetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetTypeRepository extends JpaRepository <AssetType,Long> {

}
