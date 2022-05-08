package com.ZAI.demo.services;

import com.ZAI.demo.exceptions.NotFoundException;
import com.ZAI.demo.models.Login;
import com.ZAI.demo.models.Register;
import com.ZAI.demo.models.Users;
import com.ZAI.demo.repository.UsersRepository;
import com.ZAI.demo.security.JwtUtil;
import com.ZAI.demo.security.MyUserDetails;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public List<Users> getAll() {
        return usersRepository.findAll();
    }


    public String loginUser(Login login) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return jwtUtil.generateJwtToken(authentication);
        } catch (BadCredentialsException e) {
            throw new UsernameNotFoundException("email not found " + login.getEmail());
        }
    }

    public boolean registerUser(Register register) {

        Optional<Users> user = usersRepository.findByEmail(register.getEmail());
        if (user.isPresent()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        if (!register.getPassword().equals(register.getPassword2())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        Users userToSave = Users.builder().email(
                        register.getEmail()).
                userFirstName(register.getFirstname()).
                userSurname(register.getSurname())
                .role("USER")
                .password(passwordEncoder.encode(register.getPassword()))
                .build();
        usersRepository.save(userToSave);
        return true;

    }


    public boolean changeUserPassword(String oldPassword, String newPassword, Long userId) {
        Optional<Users> user = usersRepository.findById(userId);
        if (user.isPresent()) {
            if (user.get().getPassword().equals(oldPassword)) {
                user.get().setPassword(newPassword);
                return true;
            }
        }
        return false;

    }

    public Users getById(long id) {
        return usersRepository.findById(id).orElseThrow(() -> new NotFoundException("User Not found"));
    }

    public boolean changeUserEmail(String password, String email, Long userId) {
        Optional<Users> user = usersRepository.findById(userId);
        if (user.isPresent()) {
            if (user.get().getPassword().equals(password)) {
                user.get().setEmail(email);
                return true;
            }
        }
        return false;

    }
}
