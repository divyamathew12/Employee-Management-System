package com.example.EmployeeManagementSystem.Service;

import com.example.EmployeeManagementSystem.Entity.Department;
import com.example.EmployeeManagementSystem.Entity.Designation;
import com.example.EmployeeManagementSystem.Repository.DepartmentRepository;
import com.example.EmployeeManagementSystem.Repository.DesignationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesignationService {

    private final DesignationRepository designationRepository;
    @Autowired
    public DesignationService (DesignationRepository designationRepository){
        this.designationRepository = designationRepository;
    }
    public List<Designation> getAllDesignations() {
        return designationRepository.findAll();
    }

    public Optional<Designation> getDesignationById(Long id) {
        return designationRepository.findById(id);
    }

    public Designation createDesignation (Designation designation) {
        return designationRepository.save(designation);
    }

    public Designation updateDesignation(Long id, Designation updatedDesignation) {
        Optional<Designation> existingDesignation = designationRepository.findById(id);
        if (existingDesignation.isPresent()) {
            Designation designation = existingDesignation.get();
            designation.setDesignationName(updatedDesignation.getDesignationName());
            designation.setDesignationCode(updatedDesignation.getDesignationCode());
            return designationRepository.save(designation);
        }
        return null;
    }

    public void deleteDesignation(Long id) {
        designationRepository.deleteById(id);
    }
}




