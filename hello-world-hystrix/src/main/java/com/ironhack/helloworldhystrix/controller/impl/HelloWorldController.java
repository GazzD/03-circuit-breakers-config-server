package com.ironhack.helloworldhystrix.controller.impl;

import com.ironhack.helloworldhystrix.service.impl.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping("/hello-world")
    public String helloWorld() {

        return  helloWorldService.sayHello();

    }
}
