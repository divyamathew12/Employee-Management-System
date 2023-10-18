package com.example.EmployeeManagementSystem.Service;

import com.example.EmployeeManagementSystem.Entity.*;
import com.example.EmployeeManagementSystem.dto.AssetAssignReportDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AssetAssignReportService {

    @PersistenceContext
    private EntityManager entityManager;


    public List<AssetAssignReportDTO> generateAssetAssignReport(String employeeName, String branch, String assetType,
                                                            Date assignedDateFrom, Date assignedDateTo, Date returnedDateFrom, Date returnedDateTo,
                                                            Boolean assetAssign) {
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<AssetAssignReportDTO> query = criteriaBuilder.createQuery(AssetAssignReportDTO.class);
    Root<AssetAssign> assetAssignRoot = query.from(AssetAssign.class);
    Join<Asset,AssetAssign> assetJoin = assetAssignRoot.join("asset", JoinType.LEFT);
    Join<Asset, AssetType> assetTypeJoin = assetJoin.join("assetType", JoinType.LEFT);
    Join<AssetAssign, Employee> employeeJoin = assetAssignRoot.join("employee", JoinType.LEFT);
    Join<Asset, Branch> branchJoin = assetJoin.join("branch", JoinType.LEFT);


        query.multiselect(
                assetTypeJoin.get("type").alias("assetType"),
                assetJoin.get("id").alias("assetId"),
                assetJoin.get("serialNumber"),
                employeeJoin.get("employeeName"),
                assetAssignRoot.get("assignDate"),
                assetAssignRoot.get("returnDate"),
                assetAssignRoot.get("assignRemarks"),
                assetAssignRoot.get("returnRemarks")
        );

        List<Predicate> predicates = new ArrayList<>();

        if (employeeName != null && !employeeName.isEmpty()) {
            predicates.add(criteriaBuilder.like(employeeJoin.get("employeeName"), "%" + employeeName + "%"));
        }

        if (branch != null && !branch.isEmpty()) {
            predicates.add(criteriaBuilder.equal(branchJoin.get("branchName"), branch));
        }

        if (assetType != null && !assetType.isEmpty()) {
            predicates.add(criteriaBuilder.equal(assetJoin.get("type"), assetType));
        }

        if (assignedDateFrom != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(assetAssignRoot.get("assignDate"), assignedDateFrom));
        }

        if (assignedDateTo != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(assetAssignRoot.get("assignDate"), assignedDateTo));
        }

        if (returnedDateFrom != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(assetAssignRoot.get("returnDate"), returnedDateFrom));
        }

        if (returnedDateTo != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(assetAssignRoot.get("returnDate"), returnedDateTo));
        }

        if (assetAssign != null) {
            if (assetAssign) {
                predicates.add(criteriaBuilder.isNull(assetAssignRoot.get("employee")));
            } else {
                predicates.add(criteriaBuilder.isNotNull(assetAssignRoot.get("employee")));
            }
        }
        query.where(predicates.toArray(new Predicate[0]));

        TypedQuery<AssetAssignReportDTO> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}
