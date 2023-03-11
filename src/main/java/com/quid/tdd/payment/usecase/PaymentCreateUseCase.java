package com.quid.tdd.payment.usecase;

import com.quid.tdd.order.domain.Order;
import com.quid.tdd.order.repo.OrderRepository;
import com.quid.tdd.payment.controller.model.PaymentCreateRequest;
import com.quid.tdd.payment.domain.Payment;
import com.quid.tdd.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface PaymentCreateUseCase {

    Payment createPayment(PaymentCreateRequest request);

    @Service
    @RequiredArgsConstructor
    class PaymentCreateUseCaseImpl implements PaymentCreateUseCase {

        private final PaymentRepository paymentRepository;
        private final OrderRepository orderRepository;

        @Override
        public Payment createPayment(PaymentCreateRequest request) {
            Order order = orderRepository.findById(request.orderId());
            return paymentRepository.save(request.toPayment(order));
        }
    }

}
