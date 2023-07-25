package com.example.EmployeeManagementSystem.Service;

import com.example.EmployeeManagementSystem.Entity.Branch;
import com.example.EmployeeManagementSystem.Entity.Department;
import com.example.EmployeeManagementSystem.Repository.BranchRepository;
import com.example.EmployeeManagementSystem.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    @Autowired
    public DepartmentService (DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    public Department createDepartment (Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long id, Department updatedDepartment) {
        Optional<Department> existingDepartment = departmentRepository.findById(id);
        if (existingDepartment.isPresent()) {
            Department department = existingDepartment.get();
            department.setDepartmentName(updatedDepartment.getDepartmentName());
            department.setDepartmentCode(updatedDepartment.getDepartmentCode());
            return departmentRepository.save(department);
        }
        return null;
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}




