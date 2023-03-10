package com.quid.tdd.order.usecase;

import com.quid.tdd.order.controller.model.OrderCreateRequest;
import com.quid.tdd.order.domain.Order;
import com.quid.tdd.order.repo.OrderRepository;
import com.quid.tdd.product.domain.Product;
import com.quid.tdd.product.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface OrderCreateUseCase {

    Order createOrder(OrderCreateRequest request);

    @Service
    @RequiredArgsConstructor
    class OrderCreateUseCaseImpl implements OrderCreateUseCase {

        private final OrderRepository orderRepository;
        private final ProductRepository productRepository;
        @Override
        @Transactional
        public Order createOrder(OrderCreateRequest request) {
            Product product = productRepository.findById(request.productId());
            product.reduceQuantity(request.quantity());
            return orderRepository.createOrder(request.toOrder(product));
        }

    }

}
