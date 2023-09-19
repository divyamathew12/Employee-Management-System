package com.example.EmployeeManagementSystem.Service;

import com.example.EmployeeManagementSystem.Entity.Branch;
import com.example.EmployeeManagementSystem.Entity.Employee;
import com.example.EmployeeManagementSystem.Entity.LeaveReport;
import com.example.EmployeeManagementSystem.Repository.BranchRepository;
import com.example.EmployeeManagementSystem.Repository.EmployeeRepository;
import com.example.EmployeeManagementSystem.Repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Service
public class ReportService {
    @Autowired
    ReportRepository reportRepository;
    @Autowired
    BranchRepository branchRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public LeaveReport createLeaveReport(@RequestBody LeaveReport leaveReport,
                                         @RequestBody  Employee employee,
                                         @RequestBody  Branch branch) {
        leaveReport.setStatus(leaveReport.getStatus());
        leaveReport.setFromDate(leaveReport.getFromDate());
        leaveReport.setToDate(leaveReport.getToDate());
        employeeRepository.findById(employee.getId());
        branchRepository.findById(branch.getId());


        return reportRepository.save(leaveReport);
    }

    public List<LeaveReport> getAllLeaveReports() {
        return reportRepository.findAll();
    }

    public List <LeaveReport> getLeaveReportByEmployeeIdAndFromDateGreaterThanEqualAndToDateLessThanEqualAndBranchIdAndStatus( Long employeeId, Date fromDate, Date toDate, Long branchId, String status) {
        return reportRepository.findByEmployeeIdAndFromDateGreaterThanEqualAndToDateLessThanEqualAndBranchIdAndStatus( employeeId,fromDate,toDate, branchId, status);}

    public List<LeaveReport> getLeaveDuration(Date fromDate, Date toDate){
        return reportRepository.findByFromDateGreaterThanEqualAndToDateLessThanEqual(fromDate,toDate);
    }

}

