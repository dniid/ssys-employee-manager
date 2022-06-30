package com.ssys.employeemgmt.controller;

import com.ssys.employeemgmt.model.EmployeeSalary;
import com.ssys.employeemgmt.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Collections;

@CrossOrigin("*")
@RestController
@RequestMapping("/reports/employees/salary")
public class EmployeeSalaryReport {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeSalaryReport(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public EmployeeSalary getSalaryReport(){
        EmployeeSalary salaryReport = EmployeeSalary.getInstance();
        salaryReport.setLowest(employeeRepository.getEmployeeByLowestSalary().get(0));
        salaryReport.setHighest(employeeRepository.getEmployeeByHighestSalary().get(0));
        salaryReport.setAverage(employeeRepository.getAverageSalary());

        return salaryReport;
    }


}