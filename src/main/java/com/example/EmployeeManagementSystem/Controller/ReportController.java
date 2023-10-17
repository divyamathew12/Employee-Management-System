//package com.example.EmployeeManagementSystem.Controller;
//
//import com.example.EmployeeManagementSystem.Entity.Branch;
//import com.example.EmployeeManagementSystem.Entity.Employee;
//import com.example.EmployeeManagementSystem.Entity.LeaveReport;
//import com.example.EmployeeManagementSystem.Repository.ReportRepository;
//import com.example.EmployeeManagementSystem.Service.ReportService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Date;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/leave-report")
//public class ReportController {
//    @Autowired
//    ReportService reportService;
//
//    @Autowired
//    ReportRepository reportRepository;
//
//
//    @PostMapping
//    public ResponseEntity<LeaveReport> createLeaveReport(@RequestBody LeaveReport leaveReport,
//                                                         @RequestBody Employee employee,
//                                                         @RequestBody Branch branch) {
//        LeaveReport createdLeaveReport = reportService.createLeaveReport(leaveReport, employee, branch);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdLeaveReport);
//    }
//
//
//    @GetMapping
//    public ResponseEntity<List<LeaveReport>> getAllLeaveReports() {
//        List<LeaveReport> leaveReports = reportService.getAllLeaveReports();
//        return ResponseEntity.ok(leaveReports);
//    }
//
//    @GetMapping("/report")
//    public List<LeaveReport> getLeaveReportByEmployeeIdAndFromDateGreaterThanEqualAndToDateLessThanEqualAndBranchIdAndStatus(
//                                                                                                                                      @PathVariable Long employeeId,
//                                                                                                                                      @PathVariable Date fromDate,
//                                                                                                                                      @PathVariable Date toDate,
//                                                                                                                                      @PathVariable Long branchId,
//                                                                                                                                      @PathVariable String status) {
//        return reportService.getLeaveReportByEmployeeIdAndFromDateGreaterThanEqualAndToDateLessThanEqualAndBranchIdAndStatus( employeeId, fromDate, toDate, branchId, status);
//    }
//
//
////        if (leaveReport == null) {
////            return ResponseEntity.notFound().build();
////        }
////        return ResponseEntity.ok(leaveReport);
//
//
//    @GetMapping("/leave_duration")
//    public List<LeaveReport> getLeaveDuration(@PathVariable Date fromDate, Date toDate){
//        return reportService.getLeaveDuration(fromDate, toDate);
//    }
//}


//        LocalDate fromDate = LocalDate.parse(leaveReport.getFromDate());
//        LocalDate toDate = Date.parse(leaveReport.getToDate());
//        long leaveDuration = ChronoUnit.DAYS.between(fromDate,toDate);
//
//        LeaveReport leaveReport = reportService.createLeaveReport(leaveReport, leaveDuration);
//
//        return ResponseEntity.ok(leaveReport);




//    @GetMapping("/report")
//    public List<LeaveApplication> getLeaveReport(
//            @RequestParam(required = false) Long employeeId,
//            @RequestParam(required = false) Date fromDate,
//            @RequestParam(required = false) Date toDate,
//            @RequestParam(required = false) Long branchId,
//            @RequestParam(required = false) String status){
//
//     if (employeeId != null && fromDate != null && toDate != null && branchId != null && status != null){
//         return leaveReportRepository.findByEmployeeIdAndBetweenFromDateAndToDateAndBranchAndStatus( employeeId, fromDate, toDate, branchId, status);
//        } else {
//         return Collections.emptyList();
//     }
// }

