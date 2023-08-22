package com.example.EmployeeManagementSystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class EmployeeSalary {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Basic")
    private double basic;
    @Column(name= "DA")
    private double dearnessAllowance;
    @Column(name = "HRA")
    private double houseRentAllowance;
    @Column(name = "Other Additions")
    private  double otherAdditions;
    @Column(name = "Gross Pay")
    private double grossPay;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany(mappedBy = "employeeSalary")
    private List<Payment> payments;

    public EmployeeSalary(Long id, double basic, double dearnessAllowance, double houseRentAllowance,double otherAdditions, double grossPay) {
        this.id = id;
        this.basic = basic;
        this.dearnessAllowance = dearnessAllowance;
        this.houseRentAllowance = houseRentAllowance;
        this.otherAdditions = otherAdditions;
        this.grossPay = grossPay;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public double getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }

    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
