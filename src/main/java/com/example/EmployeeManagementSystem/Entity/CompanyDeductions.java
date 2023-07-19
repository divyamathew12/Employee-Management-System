package com.example.EmployeeManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class CompanyDeductions {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Company")
    private String company;
    @Column(name = "PF")
    private String providentFund;
    @Column(name = "ESI")
    private String employeeStateInsurance;

    public CompanyDeductions(Long id,String company,String providentFund,String employeeStateInsurance) {
        this.id = id;
        this.company = company;
        this.providentFund = providentFund;
        this.employeeStateInsurance = employeeStateInsurance;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    public String getProvidentFund() {
        return providentFund;
    }

    public void setProvidentFund(String providentFund) {
        this.providentFund = providentFund;
    }
    public String getEmployeeStateInsurance() {
        return employeeStateInsurance;
    }

    public void setEmployeeStateInsurance(String employeeStateInsurance) {
        this.employeeStateInsurance = employeeStateInsurance;
    }

}
