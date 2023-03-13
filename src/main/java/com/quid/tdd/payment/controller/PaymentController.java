package com.quid.tdd.payment.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import com.quid.tdd.payment.controller.model.CreatePaymentRequest;
import com.quid.tdd.payment.controller.model.PaymentResponse;
import com.quid.tdd.payment.domain.Payment;
import com.quid.tdd.payment.usecase.PaymentCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentCreateUseCase paymentCreateUseCase;

    @PostMapping
    @ResponseStatus(CREATED)
    public void create(@RequestBody CreatePaymentRequest request) {
        paymentCreateUseCase.createPayment(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public PaymentResponse getPayment(@PathVariable(name = "id") Long id) {
        Payment payment = paymentCreateUseCase.getPayment(id);
        return PaymentResponse.of(payment);
    }

}
