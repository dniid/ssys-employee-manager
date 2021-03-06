package com.ssys.employeemgmt.controller;

import com.ssys.employeemgmt.model.EmployeeAge;
import com.ssys.employeemgmt.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/reports/employees/age")
public class EmployeeAgeReport {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeAgeReport(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public EmployeeAge getAgeReport(){
        EmployeeAge salaryReport = EmployeeAge.getInstance();
        salaryReport.setYoungest(employeeRepository.getEmployeeByYoungestAge().get(0));
        salaryReport.setOldest(employeeRepository.getEmployeeByOldestAge().get(0));
        salaryReport.setAverage(employeeRepository.getAverageAge());

        return salaryReport;
    }


}