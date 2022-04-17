package com.ZAI.demo.security;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
@EnableGlobalMethodSecurity(
        // securedEnabled = true,
        // jsr250Enabled = true,
        prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final MyUserDetailsService userDetailsService;
    private final AuthException unauthorizedHandler;
    private final RequestFilter requestFilter;
    @Bean
    public AuthException authenticationJwtTokenFilter() {
        return new AuthException();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Enable CORS and disable CSRF
        http = http.cors().and().csrf().disable();
        // Set session management to stateless
        http = http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();
        // Set unauthorized requests exception handler
        http = http
                .exceptionHandling()
                .authenticationEntryPoint(new AuthException())
                .and();

        // Set permissions on endpoints
        http.authorizeRequests()
                // Our public endpoints
                .antMatchers("/api/login/**").permitAll()
                .antMatchers("api/seance/get/current").permitAll()
                // Our private endpoints
                .antMatchers("/api/category/add").hasAuthority("ADMIN")
                .antMatchers("/api/category/remove/**").hasAuthority("ADMIN")
                .antMatchers("/api/category/add").hasAuthority("ADMIN")
                .antMatchers("/api/room/add").hasAuthority("ADMIN")
                .antMatchers("/api/seance/add").hasAuthority("ADMIN")
                .antMatchers("/api/seance/modify").hasAuthority("ADMIN")
                .antMatchers("/api/user/get/all").hasAuthority("ADMIN")
                .antMatchers("api/user/get/me").hasAuthority("USER")
                .antMatchers("/api/titles/add").hasAuthority("ADMIN")
                .antMatchers("/api/titles/remove").hasAuthority("ADMIN")
                .anyRequest().authenticated();
        http.addFilterBefore(requestFilter, UsernamePasswordAuthenticationFilter.class);
    }


}