package com.example.EmployeeManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class AssetAssign {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Assign Date")
    private Date assignDate;

    @Column(name = "Assign Remarks")
    private String assignRemarks;

    @Column(name = "Return Date")
    private Date returnDate;

    @Column(name = "Return Remarks")
    private String returnRemarks;

    @ManyToOne
    @JoinColumn(name = "asset_id")
    private Asset asset;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}



