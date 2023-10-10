package com.example.EmployeeManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Asset {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Serial Number")
    private String serialNumber;

    @Column(name = "Model Name")
    private String modelName;

    @Column(name = "Manufacturing Date")
    private Date manufacturingDate;

    @Column(name = "Specification")
    private String specification;

    @Column(name = "Added Date")
    private Date addedDate;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "asset_type_id")
    private AssetType assetType;

}

