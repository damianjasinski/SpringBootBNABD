package com.ZAI.demo.controller;

import com.ZAI.demo.models.Users;
import com.ZAI.demo.repository.UsersRepository;
import com.ZAI.demo.services.UsersService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final UsersService usersService;

    @PostMapping("/signup")
    public ResponseEntity<Map<String,Users>> signupUser(@Valid @RequestBody Users users) {
        Users savedUser = usersService.signupUser(users);
        return new ResponseEntity<>(Map.of("successfully signup", savedUser), HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public List<Users> getUsers() {
        return usersService.getAll();
    }

    @GetMapping("/get/{id}")
    public Users getUser(@PathVariable long id)
    {
        return usersService.getById(id);
    }
}
