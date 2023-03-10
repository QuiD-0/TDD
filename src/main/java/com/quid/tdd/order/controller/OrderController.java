package com.quid.tdd.order.controller;

import static org.springframework.http.HttpStatus.CREATED;

import com.quid.tdd.order.controller.model.OrderCreateRequest;
import com.quid.tdd.order.usecase.OrderCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderCreateUseCase orderCreateUseCase;
    @PostMapping
    @ResponseStatus(CREATED)
    public void createOrder(@RequestBody OrderCreateRequest request) {
        orderCreateUseCase.createOrder(request);
    }
}
