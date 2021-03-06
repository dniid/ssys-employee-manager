package com.ssys.employeemgmt.loader;

import com.ssys.employeemgmt.model.Employee;
import com.ssys.employeemgmt.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class EmployeeLoader {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeLoader(EmployeeRepository employeeRepository) throws ParseException {
        this.employeeRepository = employeeRepository;

        LoadBaseEmployees();
    }

    private void LoadBaseEmployees() throws ParseException {
        employeeRepository.save(new Employee(1L, "Anakin Skywalker", "skywalker@ssys.com.br", "Architecture", 4000.00, new SimpleDateFormat("dd-MM-yyyy").parse("01-01-1983")));
        employeeRepository.save(new Employee(2L, "Obi-Wan Kenobi", "kenobi@ssys.com.br", "Back-End", 3000.00, new SimpleDateFormat("dd-MM-yyyy").parse("01-01-1977")));
        employeeRepository.save(new Employee(3L, "Leia Organa", "organa@ssys.com.br", "DevOps", 5000.00, new SimpleDateFormat("dd-MM-yyyy").parse("01-01-1980")));
    }
}
