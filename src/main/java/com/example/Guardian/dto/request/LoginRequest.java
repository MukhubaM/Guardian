package com.example.Guardian.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

    @NotBlank(message = "Email or username is required")
    private String identifier;    //Accepts email or username

    @NotBlank(message = "Password is required")
    private String password;
}
