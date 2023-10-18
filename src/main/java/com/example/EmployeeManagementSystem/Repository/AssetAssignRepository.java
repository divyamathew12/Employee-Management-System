package com.example.EmployeeManagementSystem.Repository;

import com.example.EmployeeManagementSystem.Entity.Asset;
import com.example.EmployeeManagementSystem.Entity.AssetAssign;
import com.example.EmployeeManagementSystem.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AssetAssignRepository extends JpaRepository<AssetAssign, Long> {

    List<AssetAssign> findByAssetAndReturnDateIsNull(Asset asset);
}
