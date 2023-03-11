package com.quid.tdd.payment.repository;

import com.quid.tdd.payment.domain.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

public interface PaymentRepository {

    Payment save(Payment toPayment);

    @Repository
    @RequiredArgsConstructor
    class PaymentRepositoryImpl implements PaymentRepository {

        private final PaymentJpaRepository jpaRepository;

        @Override
        public Payment save(Payment payment) {
            return jpaRepository.save(payment);
        }
    }
}
