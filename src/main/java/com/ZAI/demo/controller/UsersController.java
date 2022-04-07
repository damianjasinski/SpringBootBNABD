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

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final UsersService usersService;

    @PostMapping("/signup")
    public ResponseEntity<Users> signupUser(@Valid @RequestBody Users users){
        usersService.signupUser(users);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/get_users")
    public List<Users> getUsers() {
        return usersService.getAll();
    }

    @GetMapping("/get_user/{id}")
    public Users getUser(@PathVariable long id)
    {
        return usersService.getById(id);
    }
}
