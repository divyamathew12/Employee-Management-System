package com.example.EmployeeManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.temporal.ChronoUnit;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Leave Report")
public class LeaveReport {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "From Date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;

    @Column(name = "To Date")
    @Temporal(TemporalType.DATE)
    private Date toDate;

    @Column(name = "Status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    public int getLeaveDuration(){

        return (int) ChronoUnit.DAYS.between(
                fromDate.toInstant(),
                toDate.toInstant()
        );
    }

}
