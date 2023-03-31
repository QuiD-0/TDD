package com.quid.tdd.config;


import feign.Logger;
import feign.Request;
import feign.Response;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor(staticName = "of")
public class FeignLogger extends Logger {

    private static final int SLOW_API_TIME = 3_000;
    public static final String SLOW_API_MESSAGE = "Slow API call.";

    @Override
    protected void log(String configKey, String format, Object... args) {
        System.out.printf(methodTag(configKey) + format + "%n", args);
    }

    @Override
    protected void logRequest(String configKey, Level logLevel, Request request) {
        log.info("Request: " + request.url());
    }

    @Override
    protected Response logAndRebufferResponse(String configKey, Level logLevel, Response response,
        long elapsedTime) throws IOException {
        if (elapsedTime > SLOW_API_TIME) {
            log.warn(SLOW_API_MESSAGE);
        }
        return super.logAndRebufferResponse(configKey, logLevel, response, elapsedTime);
    }
}