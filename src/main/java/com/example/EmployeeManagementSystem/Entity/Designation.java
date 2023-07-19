package com.example.EmployeeManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Designation {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Company")
    private String company;
    @Column(name = "Designation Name")
    private String designationName;
    @Column(name = "Designation Code")
    private String designationCode;

    public Designation(Long id, String company, String designationName, String designationCode) {
        this.id = id;
        this.company = company;
        this.designationName = designationName;
        this.designationCode = designationCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public String getDesignationCode() {
        return designationCode;
    }

    public void setDesignationCode(String designationCode) {
        this.designationCode = designationCode;
    }
}




