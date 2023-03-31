package com.quid.tdd.mock;

import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/mock/pay")
public class PayMockController {

    @GetMapping
    public UUID pay() {
        return UUID.randomUUID();
    }
}
