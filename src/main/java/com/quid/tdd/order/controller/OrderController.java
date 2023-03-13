package com.quid.tdd.order.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import com.quid.tdd.order.controller.model.OrderCreateRequest;
import com.quid.tdd.order.controller.model.OrderResponse;
import com.quid.tdd.order.domain.Order;
import com.quid.tdd.order.usecase.OrderCreateUseCase;
import com.quid.tdd.order.usecase.OrderFindUseCase;
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
@RequestMapping("/orders")
public class OrderController {

    private final OrderCreateUseCase orderCreateUseCase;
    private final OrderFindUseCase orderFindUseCase;

    @PostMapping
    @ResponseStatus(CREATED)
    public void createOrder(@RequestBody OrderCreateRequest request) {
        orderCreateUseCase.createOrder(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public OrderResponse findOrder(@PathVariable long id) {
        Order order = orderFindUseCase.findOrder(id);
        return OrderResponse.of(order);
    }
}
