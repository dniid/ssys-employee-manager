package com.ssys.employeemgmt.repository;

import com.ssys.employeemgmt.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT s FROM Employee s WHERE s.salary = (SELECT MIN(salary) FROM Employee)")
    List<Employee> getEmployeeByLowestSalary();

    @Query("SELECT s FROM Employee s WHERE s.salary = (SELECT MAX(salary) FROM Employee)")
    List<Employee> getEmployeeByHighestSalary();

    @Query("SELECT AVG(salary) FROM Employee ")
    Double getAverageSalary();

    @Query("SELECT a FROM Employee a WHERE a.birth_date = (SELECT MAX(birth_date) FROM Employee)")
    List<Employee> getEmployeeByYoungestAge();

    @Query("SELECT a FROM Employee a WHERE a.birth_date = (SELECT MIN(birth_date) FROM Employee)")
    List<Employee> getEmployeeByOldestAge();

    @Query("SELECT year(CURRENT_DATE) - AVG(year(birth_date)) FROM Employee")
    String getAverageAge();
}