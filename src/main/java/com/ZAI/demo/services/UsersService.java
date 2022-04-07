package com.ZAI.demo.services;

import com.ZAI.demo.exceptions.NotFoundException;
import com.ZAI.demo.models.Users;
import com.ZAI.demo.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public List<Users> getAll(){
        return usersRepository.findAll();
    }

    public Users signupUser(Users users){
        Optional <Users> user = usersRepository.findByEmail(users.getEmail());
        if (user.isPresent()){throw new ResponseStatusException(HttpStatus.FORBIDDEN);}
        return usersRepository.save(users);
    }

    public boolean loginUser(String email, String password){
        Optional <Users> user = usersRepository.findByEmail(email);
        return user.map(users -> users.getPassword().equals(password)).orElse(false);
    }

    public boolean changeUserPassword(String oldPassword, String newPassword, Long userId){
        Optional <Users> user = usersRepository.findById(userId);
        if(user.isPresent()){
            if(user.get().getPassword().equals(oldPassword)){
                user.get().setPassword(newPassword);
                return true;
            }
        }
        return false;

    }

    public Users getById(long id) {
        return usersRepository.findById(id).orElseThrow(() -> new NotFoundException("User Not found"));
    }

    public boolean changeUserEmail(String password, String email, Long userId){
        Optional <Users> user = usersRepository.findById(userId);
        if(user.isPresent()){
            if(user.get().getPassword().equals(password)){
                user.get().setEmail(email);
                return true;
            }
        }
        return false;

    }
}
