package com.quid.tdd.payment.gateway;

import com.quid.tdd.payment.gateway.model.PayRequest;
import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "payment-gateway", url = "http://localhost:8080/mock/pay")
public interface PaymentGateway {

    @PostMapping
    UUID requestPayment(PayRequest payRequest);
}
