package com.ZAI.demo.services;

import com.ZAI.demo.models.Employee;
import com.ZAI.demo.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public String addUser(String firstName, String lastName, double salary) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployes() {
        return null;
    }
}
