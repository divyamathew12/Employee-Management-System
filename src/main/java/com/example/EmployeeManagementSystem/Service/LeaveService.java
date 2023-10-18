package com.example.EmployeeManagementSystem.Service;

import com.example.EmployeeManagementSystem.Entity.LeaveApplication;
import com.example.EmployeeManagementSystem.Repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    public LeaveApplication createLeaveApplication(LeaveApplication leaveApplication) {
        leaveApplication.setStatus("InProgress");
        leaveApplication.setFromDate(leaveApplication.getFromDate());
        leaveApplication.setToDate(leaveApplication.getToDate());
        leaveApplication.setReason(leaveApplication.getReason());
        leaveApplication.setAppliedDate(leaveApplication.getAppliedDate());

        return leaveRepository.save(leaveApplication);
    }

    public List<LeaveApplication> getAllLeaveApplications() {
        return leaveRepository.findAll();
    }

    public LeaveApplication getLeaveApplicationById(Long id) {
        return leaveRepository.findById(id).orElse(null);
    }

    public LeaveApplication updateLeaveApplication(Long id, LeaveApplication leaveApplication) {
        LeaveApplication existingLeaveApplication = leaveRepository.findById(id).orElse(null);

      if (leaveApplication != null) {

       existingLeaveApplication.setStatus(leaveApplication.getStatus());
       existingLeaveApplication.setActionDate(leaveApplication.getActionDate());
       existingLeaveApplication.setActionRemarks(leaveApplication.getActionRemarks());

        return leaveRepository.save(leaveApplication);
      }
         return null;
   }

    public boolean deleteLeaveApplication(Long id) {
        LeaveApplication existingLeaveApplication = leaveRepository.findById(id).orElse(null);
        if (existingLeaveApplication != null) {
            leaveRepository.delete(existingLeaveApplication);
            return true;
        }
        return false;
    }
}
