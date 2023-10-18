package com.example.EmployeeManagementSystem.Service;

import com.example.EmployeeManagementSystem.Entity.Branch;
import com.example.EmployeeManagementSystem.Entity.Employee;
import com.example.EmployeeManagementSystem.Entity.LeaveApplication;
import com.example.EmployeeManagementSystem.dto.LeaveReportDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LeaveReportService{
@PersistenceContext
private EntityManager entityManager;


public List<LeaveReportDTO> generateLeaveReport(String employeeName, Date fromDate, Date toDate,  String branch, String status) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<LeaveReportDTO> query = criteriaBuilder.createQuery(LeaveReportDTO.class);
        Root<LeaveApplication> leaveApplicationRoot = query.from(LeaveApplication.class);
        Join<LeaveApplication, Employee> employeeJoin = leaveApplicationRoot.join("employee", JoinType.LEFT);
        Join<LeaveApplication, Branch> branchJoin = leaveApplicationRoot.join("branch", JoinType.LEFT);


        query.multiselect(
        employeeJoin.get("employeeName"),
        leaveApplicationRoot.get("fromDate"),
        leaveApplicationRoot.get("toDate"),
                branchJoin.get("branchName"),
        leaveApplicationRoot.get("status")
        );

        List<Predicate> predicates = new ArrayList<>();


        if (employeeName != null && !employeeName.isEmpty()) {
        predicates.add(criteriaBuilder.like(employeeJoin.get("employeeName"), "%" + employeeName + "%"));
        }

        if (fromDate != null) {
        predicates.add(criteriaBuilder.greaterThanOrEqualTo(leaveApplicationRoot.get("fromDate"), fromDate));
        }

        if (toDate != null) {
        predicates.add(criteriaBuilder.lessThanOrEqualTo(leaveApplicationRoot.get("toDate"), toDate));
        }


       if (branch != null && !branch.isEmpty()) {
        predicates.add(criteriaBuilder.equal(branchJoin.get("branchName"), branch));
     }


    if (status != null && !status.isEmpty()) {
        predicates.add(criteriaBuilder.equal(leaveApplicationRoot.get("status"), status));
        }

        query.where(predicates.toArray(new Predicate[0]));

        TypedQuery<LeaveReportDTO> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
        }
        }

