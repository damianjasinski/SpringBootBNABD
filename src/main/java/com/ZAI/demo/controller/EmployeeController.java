package com.ZAI.demo.controller;


import com.ZAI.demo.models.Employee;
import com.ZAI.demo.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAll() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/id")
    public Employee getById(@RequestParam long index) {
        return employeeService.findById(index).get();
    }
}
