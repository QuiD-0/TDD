package com.quid.tdd.payment.usecase.fake;

import com.quid.tdd.payment.gateway.PaymentGateway;
import com.quid.tdd.payment.gateway.model.PayRequest;
import java.util.UUID;

public class FakePaymentGateway implements PaymentGateway {

    @Override
    public UUID requestPayment(PayRequest payRequest) {
        return UUID.randomUUID();
    }
}
