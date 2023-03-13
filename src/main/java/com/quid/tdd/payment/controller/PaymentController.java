package com.quid.tdd.payment.controller;

import com.quid.tdd.payment.controller.model.PaymentCreateRequest;
import com.quid.tdd.payment.controller.model.PaymentResponse;
import com.quid.tdd.payment.domain.Payment;
import com.quid.tdd.payment.usecase.PaymentCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentCreateUseCase paymentCreateUseCase;

    @PostMapping
    public void create(@RequestBody PaymentCreateRequest request) {
        paymentCreateUseCase.createPayment(request);
    }

    @GetMapping("/{id}")
    public PaymentResponse getPayment(@PathVariable(name = "id") Long id) {
        Payment payment = paymentCreateUseCase.getPayment(id);
        return PaymentResponse.of(payment);
    }

}
