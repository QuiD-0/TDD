package com.quid.tdd.payment.gateway;

import com.quid.tdd.payment.gateway.model.PayRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "payment-gateway", url = "http://localhost:8081")
public interface PaymentGateway {

    @PostMapping
    Long requestPayment(PayRequest payRequest);
}
