package com.payment.backend.services;

import com.payment.backend.dto.PaymentRequest;
import com.payment.backend.entity.Payment;
import com.payment.backend.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository repo;

    public PaymentService(PaymentRepository repo) {
        this.repo = repo;
    }
    public Payment create(PaymentRequest req) {
        BigDecimal amt = new BigDecimal(req.getAmount());

        if (amt.compareTo(new BigDecimal("1.00")) < 0) {
            throw new IllegalArgumentException("Amount must be at least ₹1.00");
        }
        if (amt.compareTo(new BigDecimal("100000.00")) > 0) {
            throw new IllegalArgumentException("Amount must be at most ₹100,000.00");
        }
        Payment payment = Payment.builder()
                .name(req.getName())
                .email(req.getEmail())
                .contact(req.getContact())
                .amount(amt)
                .status("success") // for example i have set here
                .build();

        return repo.save(payment);
    }

    public List<Payment> findAll() {
        return repo.findAll();
    }
}
