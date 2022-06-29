package com.ssys.employeemgmt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeSalary {
    private Employee lowest;
    private Employee highest;
    private Double average;

    private static EmployeeSalary instance = new EmployeeSalary();

    public static EmployeeSalary getInstance() {
        return instance;
    }
}
