package com.example.EmployeeManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class CompanyDeductions {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "PF")
    private double providentFund = 12.0;
    @Column(name = "ESI")
    private double employeeStateInsurance = 1.57;

    @OneToMany(mappedBy = "companyDeductions")
    private List<Payment> payments;

    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "companyDeductions")
    private List<Employee> employees;

    public CompanyDeductions(Long id, double providentFund, double employeeStateInsurance) {
        this.id = id;
        this.providentFund = providentFund;
        this.employeeStateInsurance = employeeStateInsurance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getProvidentFund() {
        return providentFund;
    }

    public void setProvidentFund(double providentFund) {
        this.providentFund = providentFund;
    }

    public double getEmployeeStateInsurance() {
        return employeeStateInsurance;
    }

    public void setEmployeeStateInsurance(double employeeStateInsurance) {
        this.employeeStateInsurance = employeeStateInsurance;

    }
}
