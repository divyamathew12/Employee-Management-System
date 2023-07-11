package com.example.EmployeeManagementSystem.Service;

import com.example.EmployeeManagementSystem.Entity.Branch;
import com.example.EmployeeManagementSystem.Entity.Company;
import com.example.EmployeeManagementSystem.Repository.BranchRepository;
import com.example.EmployeeManagementSystem.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchService {

    private final BranchRepository branchRepository;
    @Autowired
    public BranchService (BranchRepository branchRepository){
        this.branchRepository = branchRepository;
    }
    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }

    public Optional<Branch> getBranchById(Long id) {
        return branchRepository.findById(id);
    }

    public Branch createBranch (Branch branch) {
        return branchRepository.save(branch);
    }

    public Branch updateBranch(Long id, Branch updatedBranch) {
        Optional<Branch> existingBranch = branchRepository.findById(id);
        if (existingBranch.isPresent()) {
            Branch branch = existingBranch.get();
            branch.setBranchName(updatedBranch.getBranchName());
            branch.setCompany(updatedBranch.getCompany());
            branch.setBranchCode(updatedBranch.getBranchCode());
            return branchRepository.save(branch);
        }
        return null;
    }

    public void deleteBranch(Long id) {
        branchRepository.deleteById(id);
    }
}




