package com.ZAI.demo.models;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
public class Register {
    String firstname;
    String surname;
    @Email
    String email;
    @Pattern(regexp = "^.{8,}$")
    String password;
    @Pattern(regexp = "^.{8,}$")
    String password2;
}
