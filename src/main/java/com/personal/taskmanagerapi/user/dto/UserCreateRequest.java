package com.personal.taskmanagerapi.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateRequest {
    //Validation so that the name cannot be blank
    @NotBlank(message="Name is required")
    private String name;

    //Validation so that email is valid and not blank
    @Email(message="Email must be valid")
    @NotBlank(message="Email is required")
    private String email;
}
