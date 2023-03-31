package com.quid.tdd.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenFeignConfig {
    @Bean
    public Logger feignLogger() {
        return FeignLogger.of();
    }
}
