package com.ZAI.demo.controller;


import com.ZAI.demo.models.Login;
import com.ZAI.demo.models.Users;
import com.ZAI.demo.security.JwtUtil;
import com.ZAI.demo.security.MyUserDetails;
import com.ZAI.demo.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/login")
public class LoginController {

    private final UsersService usersService;
    private final PasswordEncoder pwEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/signin")
    public ResponseEntity<Map<String, String>> signinUser(@Valid @RequestBody Login login) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtil.generateJwtToken(authentication);

            MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
            List<String> roles = userDetails.getAuthorities().stream()
                    .map(item -> item.getAuthority())
                    .collect(Collectors.toList());
            return new ResponseEntity<>(Map.of("message", "succesfully logged in", "jwt", jwt), HttpStatus.OK);
        } catch (BadCredentialsException e) {
            throw new UsernameNotFoundException("email not found " + login.getEmail());
        }

    }


    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> signupUser(@Valid @RequestBody Login login) {
        return new ResponseEntity<>(Map.of("successfully signup", login.getEmail()), HttpStatus.OK);
    }


}
