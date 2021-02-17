package com.ironhack.helloworldhystrix.service.impl;

import com.ironhack.helloworldhystrix.client.HelloClient;
import com.ironhack.helloworldhystrix.client.WorldClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    @Autowired
    private HelloClient helloClient;

    @Autowired
    private WorldClient worldClient;


    @HystrixCommand(fallbackMethod = "fallback")
    public String sayHello() {

        String hello = helloClient.hello();
        String world = worldClient.world();
        return hello + world;
    }

    public String fallback() {
        return "Cache Hello World uwu";
    }



}
