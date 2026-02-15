package com.payment.backend.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class LoginResponse {
    private boolean success;
    private String token;
    private String message;
}

