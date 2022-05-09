package com.ZAI.demo.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Getter
@Setter
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
