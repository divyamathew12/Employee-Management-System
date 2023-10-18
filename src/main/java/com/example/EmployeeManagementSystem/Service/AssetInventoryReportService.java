package com.example.EmployeeManagementSystem.Service;

import com.example.EmployeeManagementSystem.Entity.Asset;
import com.example.EmployeeManagementSystem.Entity.AssetAssign;
import com.example.EmployeeManagementSystem.Entity.AssetType;
import com.example.EmployeeManagementSystem.Entity.Branch;
import com.example.EmployeeManagementSystem.dto.AssetInventoryReportDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssetInventoryReportService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<AssetInventoryReportDTO> generateAssetInventoryReport(String branch, String assetType, Boolean assetAssign){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AssetInventoryReportDTO> query = criteriaBuilder.createQuery(AssetInventoryReportDTO.class);
        Root<Asset> assetRoot = query.from(Asset.class);
        Join<Asset, AssetAssign> assetAssignJoin = assetRoot.join("assetAssign",JoinType.LEFT);
        Join<Asset, AssetType> assetTypeJoin = assetRoot.join("assetType", JoinType.LEFT);
        Join<Asset, Branch> branchJoin = assetRoot.join("branch", JoinType.LEFT);

        query.multiselect(
                branchJoin.get("branchName").alias("branchName"),
                assetTypeJoin.get("type").alias("assetType"),
                assetRoot.get("serialNumber"),
                assetRoot.get("modelName"),
                assetRoot.get("manufacturingDate"),
                assetRoot.get("specification"),
                assetRoot.get("addedDate")

        );
        List<Predicate> predicates = new ArrayList();

        if (branch != null && !branch.isEmpty()) {
            predicates.add(criteriaBuilder.equal(branchJoin.get("branchName"), branch));
        }

        if (assetType != null && !assetType.isEmpty()) {
            predicates.add(criteriaBuilder.equal(assetTypeJoin.get("type"), assetType));
        }

        if (assetAssign != null) {
            predicates.add(assetAssign ?
                    criteriaBuilder.isNotNull(assetAssignJoin.get("assignedTo")) :
                    criteriaBuilder.isNull(assetAssignJoin.get("assignedTo")));
        }

        if (!predicates.isEmpty()) {
            query.where(predicates.toArray(new Predicate[0]));
        }

        TypedQuery<AssetInventoryReportDTO> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}



