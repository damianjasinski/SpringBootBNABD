package com.ZAI.demo.controller;

import com.ZAI.demo.models.Users;
import com.ZAI.demo.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@EqualsAndHashCode
public class HomeController {

    private final UsersRepository usersRepository;


    @GetMapping("/users")
    public List<Users> getUsers() {
        return usersRepository.findAll();
    }

}
