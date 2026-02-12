package com.payment.backend.controller;

import com.payment.backend.dto.PaymentRequest;
import com.payment.backend.entity.Payment;
import com.payment.backend.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")

public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping("/payment")
    public ResponseEntity<Map<String, Object>> createPayment(@Valid @RequestBody PaymentRequest req) {
        Payment saved = service.create(req);

        Map<String, Object> data = new HashMap<>();
        data.put("name", saved.getName());
        data.put("email", saved.getEmail());
        data.put("amount", saved.getAmount());
        data.put("status", saved.getStatus());

        Map<String, Object> res = new HashMap<>();
        res.put("success", true);
        res.put("message", "Payment processed successfully");
        res.put("paymentId", saved.getId());
        res.put("data", data);

        return ResponseEntity.status(201).body(res);
    }

    @GetMapping("/payments")
    public List<Payment> listPayments() {
        return service.findAll();
    }
}
