package com.example.EmployeeManagementSystem.Controller;

import com.example.EmployeeManagementSystem.Entity.LeaveApplication;
import com.example.EmployeeManagementSystem.Service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leave-applications")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @PostMapping
    public ResponseEntity<LeaveApplication> createLeaveApplication(@RequestBody LeaveApplication leaveApplication) {
        LeaveApplication createdLeaveApplication = leaveService.createLeaveApplication(leaveApplication);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLeaveApplication);
    }

    @GetMapping
    public ResponseEntity<List<LeaveApplication>> getAllLeaveApplications() {
        List<LeaveApplication> leaveApplications = leaveService.getAllLeaveApplications();
        return ResponseEntity.ok(leaveApplications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveApplication> getLeaveApplicationById(@PathVariable Long id) {
        LeaveApplication leaveApplication = leaveService.getLeaveApplicationById(id);
        if (leaveApplication == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(leaveApplication);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeaveApplication> updateLeaveApplication(@PathVariable Long id, @RequestBody LeaveApplication leaveApplication) {
        LeaveApplication updatedLeaveApplication = leaveService.updateLeaveApplication(id, leaveApplication);
        if (updatedLeaveApplication == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedLeaveApplication);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeaveApplication(@PathVariable Long id) {
        if (leaveService.deleteLeaveApplication(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
