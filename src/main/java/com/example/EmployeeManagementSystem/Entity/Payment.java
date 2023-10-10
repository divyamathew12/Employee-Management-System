package com.example.EmployeeManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Payment {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Month")
    private String month;
    @Column(name = "Year")
    private int year;
    @Column(name = "Total Pay")
    private double totalPay;
    @Column(name = "Total Deduction")
    private double totalDeduction;
    @Column(name = "Net Pay")
    private double netPay;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name ="deduction_id")
    private CompanyDeductions companyDeductions;

    @ManyToOne
    @JoinColumn(name ="salary_id")
    private EmployeeSalary employeeSalary;

    @ManyToOne
    @JoinColumn(name = "salary_advance_id")
    private SalaryAdvance salaryAdvance;

    public Payment(Long id, String month, int year, double netPay, double totalPay, double totalDeduction) {
        this.id = id;
        this.month = month;
        this.year = year;
        this.netPay = netPay;
        this.totalPay = totalPay;
        this.totalDeduction = totalDeduction;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public Double getNetPay() {
        return netPay;
    }
    public void setNetPay(double netPay) {
        this.netPay = netPay;
    }
    public double getTotalPay() {
        return totalPay;
    }
    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }
    public double getTotalDeduction() {
        return totalDeduction;
    }
    public void setTotalDeduction(double totalDeduction) {
        this.totalDeduction = totalDeduction;
    }

    public CompanyDeductions getCompanyDeductions() {
        return companyDeductions;
    }
    public void setCompanyDeductions(CompanyDeductions companyDeductions) {
        this.companyDeductions = companyDeductions;
    }
    public EmployeeSalary getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(EmployeeSalary employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

}



