package com.example.EmployeeManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class SalaryAdvance {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Month")
    private int month;

    @Column(name = "Year")
    private int year;

    @Column(name = "Advance Amount")
    private double advanceAmount;

    @Column (name = "Status")
    private String status;

    @Column(name = "Applied Date")
    private LocalDate appliedDate;

    @Column(name = "Action Date")
    @Temporal(TemporalType.DATE)
    private LocalDate actionDate;

    @Column(name = "Action Remarks")
    private String actionRemarks;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany(mappedBy = "salaryAdvance")
    private List<Payment> payments = new ArrayList<>();

}
