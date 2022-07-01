package com.ssys.employeemgmt;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.ssys.employeemgmt.controller.EmployeeController;
import com.ssys.employeemgmt.model.Employee;
import com.ssys.employeemgmt.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest{
    @MockBean
    private EmployeeRepository employeeRepository;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateEmployee() throws Exception {
        Employee employee = new Employee(4L, "Test", "test@ssys.com.br", "TestDepart", 1234.5, new SimpleDateFormat("dd-MM-yyyy").parse("01-01-1111"));
        mockMvc.perform(post("/employees").header("AUTH_API_KEY","ssys").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isOk())
                .andDo(print());
    }
    @Test
    void shouldReturnEmployee() throws Exception {
        long id = 3L;
        Employee employee = new Employee(id, "Test", "test@ssys.com.br", "TestDepart", 1234.5, new SimpleDateFormat("dd-MM-yyyy").parse("01-01-1111"));
        when(employeeRepository.findById(id)).thenReturn(Optional.of(employee));
        mockMvc.perform(get("/employees/{id}", id).header("AUTH_API_KEY","ssys")).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(employee.getName()))
                .andExpect(jsonPath("$.email").value(employee.getEmail()))
                .andExpect(jsonPath("$.department").value(employee.getDepartment()))
                .andExpect(jsonPath("$.salary").value(employee.getSalary()))
                .andDo(print());
    }
    @Test
    void shouldReturnNotFoundEmployee() throws Exception {
        long id = 3L;
        when(employeeRepository.findById(id)).thenReturn(Optional.empty());
        mockMvc.perform(get("/employees/{id}", id).header("AUTH_API_KEY","ssys"))
                .andExpect(status().isNotFound())
                .andDo(print());
    }
    @Test
    void shouldReturnListOfEmployees() throws Exception {
        List<Employee> employees = new ArrayList<>(
                Arrays.asList(new Employee(4L, "Test 4", "test4@ssys.com.br", "TestDepart4", 4234.5, new SimpleDateFormat("dd-MM-yyyy").parse("04-04-1444")),
                        new Employee(5L, "Test 5", "test5@ssys.com.br", "TestDepart5", 5234.5, new SimpleDateFormat("dd-MM-yyyy").parse("05-05-1555")),
                        new Employee(6L, "Test 6", "test6@ssys.com.br", "TestDepart6", 6234.5, new SimpleDateFormat("dd-MM-yyyy").parse("06-06-1666"))));
        when(employeeRepository.findAll()).thenReturn(employees);
        mockMvc.perform(get("/employees").header("AUTH_API_KEY","ssys"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(employees.size()))
                .andDo(print());
    }

    @Test
    void shouldUpdateEmployee() throws Exception {
        long id = 3L;
        Employee employee = new Employee(id, "Test", "test@ssys.com.br", "TestDepart", 1234.5, new SimpleDateFormat("dd-MM-yyyy").parse("01-01-1111"));
        Employee updatedemployee = new Employee(id, "Update", "update@ssys.com.br", "UpdateDepart", 1234.5, new SimpleDateFormat("dd-MM-yyyy").parse("01-01-1111"));
        when(employeeRepository.findById(id)).thenReturn(Optional.of(employee));
        when(employeeRepository.save(any(Employee.class))).thenReturn(updatedemployee);
        mockMvc.perform(put("/employees/{id}", id).header("AUTH_API_KEY","ssys").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedemployee)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(employee.getName()))
                .andExpect(jsonPath("$.email").value(employee.getEmail()))
                .andExpect(jsonPath("$.department").value(employee.getDepartment()))
                .andExpect(jsonPath("$.salary").value(employee.getSalary()))
                .andDo(print());
    }

    @Test
    void shouldReturnNotFoundUpdateEmployee() throws Exception {
        long id = 3L;
        Employee updatedemployee = new Employee(id, "Update", "update@ssys.com.br", "UpdateDepart", 1234.5, new SimpleDateFormat("dd-MM-yyyy").parse("01-01-1111"));
        when(employeeRepository.findById(id)).thenReturn(Optional.empty());
        when(employeeRepository.save(any(Employee.class))).thenReturn(updatedemployee);
        mockMvc.perform(put("/employees/{id}", id).header("AUTH_API_KEY","ssys").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedemployee)))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    void shouldDeleteEmployee() throws Exception {
        long id = 3L;
        doNothing().when(employeeRepository).deleteById(id);
        mockMvc.perform(delete("/employees/{id}", id).header("AUTH_API_KEY","ssys"))
                .andExpect(status().isNotFound())
                .andDo(print());
    }
}