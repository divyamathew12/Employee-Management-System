package com.example.EmployeeManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Employee {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Employee Name")
    private String employeeName;
    @Column(name = "Branch")
    private String branch;

    @Column(name = "Department")
    private String department;

    @Column(name = "Designation")
    private String designation;

    @Column(name = "Mobile Number")
    private String mobile;
    @Column(name = "Email ID")
    private String email;
    @Column(name = "Blood Group")
    private String bloodGroup;

    public Employee(Long id, String employeeName,String branch, String department,String designation,String mobile, String email,String bloodGroup) {
        this.id = id;
        this.employeeName = employeeName;
        this.branch = branch;
        this.department = department;
        this.designation = designation;
        this.mobile = mobile;
        this.email = email;
        this.bloodGroup = bloodGroup;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }



}


