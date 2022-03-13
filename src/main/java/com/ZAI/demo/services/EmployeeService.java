package com.ZAI.demo.services;

import com.ZAI.demo.models.Employee;

import java.util.List;

public interface EmployeeService {

    String addUser(String firstName, String lastName, double salary);
    List<Employee> getAllEmployes();
}
