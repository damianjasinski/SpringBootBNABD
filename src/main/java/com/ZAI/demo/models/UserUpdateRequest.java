package com.ZAI.demo.models;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserUpdateRequest {

    @NotNull
    String newEmail;

    @NotNull
    String oldPassword;

    @NotNull
    String newPassword;
}
