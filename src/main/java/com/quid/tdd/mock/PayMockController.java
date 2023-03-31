package com.quid.tdd.mock;

import com.quid.tdd.payment.gateway.model.PayRequest;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/mock")
public class PayMockController {

    @PostMapping("/pay")
    public UUID pay(@RequestBody PayRequest payRequest) {
        History.check(payRequest.transactionId());
        return UUID.randomUUID();
    }


    private static class History {
        private static Set<UUID> transactionList = new HashSet<>();
        private static void check(UUID transactionId) {
            if (transactionList.contains(transactionId)) {
                throw new IllegalArgumentException("transactionId is already used");
            }
            transactionList.add(transactionId);
        }
    }
}
