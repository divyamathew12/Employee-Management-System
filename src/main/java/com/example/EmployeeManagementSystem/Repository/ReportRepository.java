package com.example.EmployeeManagementSystem.Repository;

import com.example.EmployeeManagementSystem.Entity.LeaveReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<LeaveReport, Long> {
    List<LeaveReport> findByEmployeeIdAndFromDateGreaterThanEqualAndToDateLessThanEqualAndBranchIdAndStatus( Long employeeId, Date fromDate, Date toDate, Long branchId, String status);
    List<LeaveReport> findByFromDateGreaterThanEqualAndToDateLessThanEqual(Date fromDate, Date toDate);

}
