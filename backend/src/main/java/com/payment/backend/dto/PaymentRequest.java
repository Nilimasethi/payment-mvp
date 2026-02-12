package com.payment.backend.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be 3 to 50 characters")
    @Pattern(
            regexp = "^[A-Za-z ]+$",
            message = "Name must contain alphabets and spaces only"
    )
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Contact is required")
    @Pattern(
            regexp = "^\\d{10}$",
            message = "Contact must be exactly 10 digits"
    )
    private String contact;

    @NotBlank(message = "Amount is required")
    @Pattern(regexp = "^\\d+\\.\\d{2}$", message = "Amount must be in format 100.00")
    private String amount;

}
