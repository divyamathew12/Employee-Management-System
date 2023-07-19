package com.example.EmployeeManagementSystem.Controller;

import com.example.EmployeeManagementSystem.Entity.Department;
import com.example.EmployeeManagementSystem.Entity.Designation;
import com.example.EmployeeManagementSystem.Service.DepartmentService;
import com.example.EmployeeManagementSystem.Service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/designations")
public class DesignationController {

    private final DesignationService designationService;

    @Autowired
    public DesignationController(DesignationService designationService) {
        this.designationService = designationService;
    }

    @GetMapping
    public List<Designation> getAllDesignations() {
        return designationService.getAllDesignations();
    }

    @GetMapping("/{id}")
    public Optional<Designation> getDesignationById(@PathVariable Long id) {
        return designationService.getDesignationById(id);
    }

    @PostMapping
    public Designation createDesignation(@RequestBody Designation designation) {
        return designationService.createDesignation(designation);
    }

    @PutMapping("/{id}")
    public Designation updateDesignation(@PathVariable Long id, @RequestBody Designation designation) {
        return designationService.updateDesignation(id, designation);
    }

    @DeleteMapping("/{id}")
    public void deleteDesignation(@PathVariable Long id) {
        designationService.deleteDesignation(id);
    }
}
