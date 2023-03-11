package com.quid.tdd.payment.usecase.fake;

import com.quid.tdd.payment.domain.Payment;
import com.quid.tdd.payment.repository.PaymentRepository;
import java.util.HashMap;
import java.util.Map;

public class FakePaymentRepository implements PaymentRepository {

    Map<Long, Payment> persistence = new HashMap<>();

    @Override
    public Payment save(Payment payment) {
        persistence.put(1L, payment);
        return payment;
    }
}
