package com.example.EmployeeManagementSystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Data
@NoArgsConstructor
public class EmployeeSalary {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Month")
    private String month;
    @Column(name = "Year")
    private int year;
    @Column(name = "Basic")
    private double basic;
    @Column(name= "DA")
    private double dearnessAllowance;
    @Column(name = "HRA")
    private double houseRentAllowance;
    @Column(name = "Other Additions")
    private  double otherAdditions;
    @Column(name = "Total Salary")
    private double totalSalary;
    @Column(name = "Total Deduction")
    private double totalDeduction;
    @Column(name = "Net Salary")
    private double netSalary;
    @Column(name = "Net Pay")
    private String netPay;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name ="deduction_id")
    private CompanyDeductions companyDeductions;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public EmployeeSalary(Long id, String month, int year, double basic, double dearnessAllowance, double houseRentAllowance, double otherAdditions, String deductions, String netPay) {
        this.id = id;
        this.month = month;
        this.year = year;
        this.basic = basic;
        this.dearnessAllowance = dearnessAllowance;
        this.houseRentAllowance = houseRentAllowance;
        this.otherAdditions = otherAdditions;
        this.netPay = netPay;
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

    public double getBasic() {
        return basic;
    }

    public void setBasic(double basic) {
        this.basic = basic;
    }

    public double getDearnessAllowance() {
        return dearnessAllowance;
    }

    public void setDearnessAllowance(double dearnessAllowance) {
        this.dearnessAllowance = dearnessAllowance;
    }
    public double getHouseRentAllowance() {
        return houseRentAllowance;
    }

    public void setHouseRentAllowance(double houseRentAllowance) {
        this.houseRentAllowance = houseRentAllowance;
    }
    public double getOtherAdditions() {
        return otherAdditions;
    }

    public void setOtherAdditions(double otherAdditions) {
        this.otherAdditions = otherAdditions;
    }

    public String getNetPay() {
        return netPay;
    }

    public void setNetPay(String netPay) {
        this.netPay = netPay;
    }
    public double getTotalSalary() {
        return totalSalary;
    }
    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }
    public double getTotalDeduction() {
        return totalDeduction;
    }
    public void setTotalDeduction(double totalDeduction) {
        this.totalDeduction = totalDeduction;
    }
    public double getNetSalary() {
        return netSalary;
    }
    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }
}
