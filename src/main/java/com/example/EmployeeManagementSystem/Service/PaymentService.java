package com.example.EmployeeManagementSystem.Service;


import com.example.EmployeeManagementSystem.Entity.CompanyDeductions;
import com.example.EmployeeManagementSystem.Entity.EmployeeSalary;
import com.example.EmployeeManagementSystem.Entity.Payment;
import com.example.EmployeeManagementSystem.Repository.DeductionRepository;
import com.example.EmployeeManagementSystem.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    private CompanyDeductions companyDeductions;
    private DeductionService deductionService;
    private EmployeeSalary employeeSalary;
    private EmployeeService employeeService;
    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Autowired
    private DeductionRepository deductionRepository;
    @Autowired
    private SalaryService salaryService;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public List<Payment> getByEmployeeId(Long employeeId){return paymentRepository.findByEmployeeId(employeeId); }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
    public Payment savePayment(Payment payment) {

        if (this.companyDeductions == null) {
            this.companyDeductions = new CompanyDeductions();

            CompanyDeductions deductions = payment.getCompanyDeductions();
            EmployeeSalary employeeSalary = payment.getEmployeeSalary();
            double basic = employeeSalary.getBasic();
            double dearnessAllowance = employeeSalary.getDearnessAllowance();
            double houseRentAllowance = employeeSalary.getHouseRentAllowance();
            double otherAdditions = employeeSalary.getOtherAdditions();
            double providentFund = this.companyDeductions.getProvidentFund();
            double employeeStateInsurance = this.companyDeductions.getEmployeeStateInsurance();

            double totalPay = basic + dearnessAllowance + houseRentAllowance + otherAdditions;

            double totalDeduction = totalPay * (providentFund + employeeStateInsurance) / 100;

            double netPay = totalPay - totalDeduction;

            deductions.setProvidentFund(providentFund);
            deductions.setEmployeeStateInsurance(employeeStateInsurance);
            employeeSalary.setDearnessAllowance(dearnessAllowance);
            employeeSalary.setHouseRentAllowance(houseRentAllowance);
            employeeSalary.setOtherAdditions(otherAdditions);
            payment.setTotalPay(totalPay);
            payment.setTotalDeduction(totalDeduction);
            payment.setNetPay(netPay);

            return paymentRepository.save(payment);

        } else {
        throw new IllegalStateException("Company deductions are not set for this employee.");
        }
        }

    public Payment updatePayment(Long id, Payment updatedPayment) {
        Optional<Payment> existingPayment = paymentRepository.findById(id);
        if (existingPayment.isPresent()) {
            Payment payment = existingPayment.get();
            payment.setMonth(updatedPayment.getMonth());
            payment.setYear(updatedPayment.getYear());
            payment.setNetPay(updatedPayment.getNetPay());

            return paymentRepository.save(payment);
        }
        return null;
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}



