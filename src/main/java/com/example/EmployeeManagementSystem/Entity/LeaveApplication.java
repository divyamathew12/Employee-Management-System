package com.example.EmployeeManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class LeaveApplication {

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

    @Column(name = "Reason")
    private String reason;

    @Column(name = "Status")
    private String status;

    @Column(name = "Applied Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date appliedDate;

    @Column(name = "Action Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actionDate;

    @Column(name = "Action Remarks")
    private String actionRemarks;


}
