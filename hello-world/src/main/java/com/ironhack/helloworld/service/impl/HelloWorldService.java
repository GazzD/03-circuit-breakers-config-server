package com.ironhack.helloworld.service.impl;

import com.ironhack.helloworld.client.HelloClient;
import com.ironhack.helloworld.client.WorldClient;
import com.ironhack.helloworld.controller.dto.ComplexDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    @Autowired
    private HelloClient helloClient;

    @Autowired
    private WorldClient worldClient;

    private CircuitBreakerFactory circuitBreakerFactory = new Resilience4JCircuitBreakerFactory();

    public String sayHello() {

        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("world-service");

        String hello = helloClient.hello();
        Long id = 1L;
        String world = circuitBreaker.run(() -> worldClient.world(), throwable -> worldFallback(id));
//        String world = circuitBreaker.run(() -> worldClient.world(), throwable -> worldFallback());



        if (world == null) {
            return "Error";
        }
        return hello + world;
    }

    private String worldFallback(Long id) {
        return null;

    }
}
