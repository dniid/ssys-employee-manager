package com.ssys.employeemgmt.loader;

import com.ssys.employeemgmt.model.Employee;
import com.ssys.employeemgmt.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeLoader {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeLoader(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

        LoadBaseEmployees();
    }

    private void LoadBaseEmployees(){
        employeeRepository.save(new Employee(1, "Anakin Skywalker", "skywalker@ssys.com.br", "Architecture", 4000.00, "1983-01-01"));
        employeeRepository.save(new Employee(2, "Obi-Wan Kenobi", "kenobi@ssys.com.br", "Back-End", 3000.00, "1977-01-01"));
        employeeRepository.save(new Employee(3, "Leia Organa", "organa@ssys.com.br", "DevOps", 5000.00, "1980-01-01"));
    }
}
