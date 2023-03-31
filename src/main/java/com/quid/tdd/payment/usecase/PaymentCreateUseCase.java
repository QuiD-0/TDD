package com.quid.tdd.payment.usecase;

import com.quid.tdd.order.domain.Order;
import com.quid.tdd.order.repo.OrderRepository;
import com.quid.tdd.payment.controller.model.CreatePaymentRequest;
import com.quid.tdd.payment.domain.Payment;
import com.quid.tdd.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface PaymentCreateUseCase {

    Payment createPayment(CreatePaymentRequest request);

    Payment getPayment(Long id);

    @Service
    @Transactional
    @RequiredArgsConstructor
    class PaymentCreateUseCaseImpl implements PaymentCreateUseCase {

        private final PaymentRepository paymentRepository;
        private final OrderRepository orderRepository;

        @Override
        public Payment createPayment(CreatePaymentRequest request) {
            Order order = orderRepository.findById(request.orderId());
            Long payTransactionId = 1L;
            order.payComplete();

            return paymentRepository.save(request.toPayment(order,payTransactionId));
        }

        @Override
        public Payment getPayment(Long id) {
            return paymentRepository.findById(id);
        }
    }

}
