package com.ssys.employeemgmt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeAge {
    private Employee youngest;
    private Employee oldest;
    private String average;

    private static EmployeeAge instance = new EmployeeAge();

    public static EmployeeAge getInstance() {
        return instance;
    }
}
