package com.ZAI.demo.services;

import com.ZAI.demo.models.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    void addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Optional<Employee> findById(long id);
    void deleteById(long id);
}
