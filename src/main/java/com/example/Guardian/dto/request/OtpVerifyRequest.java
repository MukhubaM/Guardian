package com.example.Guardian.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class OtpVerifyRequest {

    @NotBlank(message = "Email is required")
    @Email
    private String email;

    @NotBlank(message = "OTP code is required")
    @Size(min = 6, max = 6, message = "OTP must be digits")
    @Pattern(regexp = "\\d{6}", message = "OTP must be numeric")
    private String code;

    @NotBlank(message = "OTP type is required")
    private String otpType;
}
