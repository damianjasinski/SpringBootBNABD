package com.ZAI.demo.controller;

import com.ZAI.demo.services.EmployeeService;
import com.ZAI.demo.services.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final EmployeeService employeeService;

    public HomeController(@Autowired EmployeeServiceImpl userService) {
        this.employeeService = userService;
    }

//    @GetMapping("/users")
//    public List<User> getUsers() {
//
//    }

}
