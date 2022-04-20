package com.ZAI.demo.security;

import com.ZAI.demo.models.Users;
import com.ZAI.demo.repository.UsersRepository;
import lombok.Data;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Data
public class MyUserDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Override
    public MyUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional <Users> optUser = usersRepository.findByEmail(email);
        if (optUser.isEmpty()) {
            throw new UsernameNotFoundException("Email not found with username: " + email);
        } else {
            Users user = optUser.get();
            return MyUserDetails.build(user);

        }
    }
}
