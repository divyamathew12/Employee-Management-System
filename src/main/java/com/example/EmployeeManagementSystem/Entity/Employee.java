package com.example.EmployeeManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Employee Name")
    private String employeeName;
    @Column(name = "Mobile Number")
    private String mobile;
    @Column(name = "Email ID")
    private String email;
    @Column(name = "Blood Group")
    private String bloodGroup;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "designation_id")
    private Designation designation;

    @ManyToOne
    @JoinColumn(name = "company_id" )
    private Company company;

    @ManyToOne
    @JoinColumn(name = "deduction_id")
    private CompanyDeductions companyDeductions;

    @OneToOne(mappedBy = "employee")
    private Payment payment;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeSalary>employeeSalaries = new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    private List<LeaveReport>leaveReports = new ArrayList<>();


    public Employee(Long id, String employeeName,String mobile, String email,String bloodGroup) {
        this.id = id;
        this.employeeName = employeeName;
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


