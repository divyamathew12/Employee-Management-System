package com.example.EmployeeManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Branch {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Branch Name")
    private String branchName;
    @Column(name = "Company")
    private String company;
    @Column(name = "Branch Code")
    private String branchCode;

    public Branch(Long id,String branchName, String company,String branchCode ) {
        this.id = id;
        this.branchName = branchName;
        this.company = company;
        this.branchCode = branchCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

}
