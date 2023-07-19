package com.example.EmployeeManagementSystem.Entity;

import jakarta.persistence.*;

@Entity
public class Salary {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Employee")
    private String employee;
    @Column(name = "Month")
    private String month;
    @Column(name = "Year")
    private String year;
    @Column(name = "Basic")
    private String basic;
    @Column(name= "DA")
    private String dearnessAllowance;
    @Column(name = "HRA")
    private String houseRentAllowance;
    @Column(name = "Other Additions")
    private  String otherAdditions;
    @Column(name = "Deductions")
    private String deductions;
    @Column(name = "Net Pay")
    private String netPay;

    public Salary(Long id,String employee,String month,String year,String basic,String dearnessAllowance,String houseRentAllowance,String otherAdditions,String deductions,String netPay) {
        this.id = id;
        this.employee = employee;
        this.month = month;
        this.year = year;
        this.basic = basic;
        this.dearnessAllowance = dearnessAllowance;
        this.houseRentAllowance = houseRentAllowance;
        this.otherAdditions = otherAdditions;
        this.deductions = deductions;
        this.netPay = netPay;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }
    public String getDearnessAllowance() {
        return dearnessAllowance;
    }

    public void setDearnessAllowance(String dearnessAllowance) {
        this.dearnessAllowance = dearnessAllowance;
    }
    public String getHouseRentAllowance() {
        return houseRentAllowance;
    }

    public void setHouseRentAllowance(String houseRentAllowance) {
        this.houseRentAllowance = houseRentAllowance;
    }
    public String getOtherAdditions() {
        return otherAdditions;
    }

    public void setOtherAdditions(String otherAdditions) {
        this.otherAdditions = otherAdditions;
    }
    public String getDeductions() {
        return deductions;
    }

    public void setDeductions(String deductions) {
        this.deductions = deductions;
    }
    public String getNetPay() {
        return netPay;
    }

    public void setNetPay(String netPay) {
        this.netPay = netPay;
    }


}
