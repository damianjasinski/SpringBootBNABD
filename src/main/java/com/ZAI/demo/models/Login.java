package com.ZAI.demo.models;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
public class Login {

    @Email
    String email;
    @Pattern(regexp = "^.{8,}$")
    String password;

}
