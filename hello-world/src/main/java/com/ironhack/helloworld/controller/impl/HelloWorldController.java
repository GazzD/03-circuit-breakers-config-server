package com.ironhack.helloworld.controller.impl;

import com.ironhack.helloworld.client.HelloClient;
import com.ironhack.helloworld.client.WorldClient;
import com.ironhack.helloworld.service.impl.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping("/hello-world")
    public String helloWorld() {
        return helloWorldService.sayHello();
    }

}
