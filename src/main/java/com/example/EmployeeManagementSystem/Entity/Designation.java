package com.example.EmployeeManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Designation {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Designation Name")
    private String designationName;
    @Column(name = "Designation Code")
    private String designationCode;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Designation(Long id, String designationName, String designationCode) {
        this.id = id;
        this.designationName = designationName;
        this.designationCode = designationCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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




