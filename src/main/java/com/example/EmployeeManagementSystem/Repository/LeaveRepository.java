package com.example.EmployeeManagementSystem.Repository;


import com.example.EmployeeManagementSystem.Entity.LeaveApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LeaveRepository extends JpaRepository<LeaveApplication, Long> {

}