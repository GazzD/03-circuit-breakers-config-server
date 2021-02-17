package com.ironhack.hello.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${important.value}")
    private String value1;

    @Value("${important.value2}")
    private String value2;

    @Value("${important.value3}")
    private String value3;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/hello")
    public String hello() {

        logger.info(value1);
        logger.info(value2);
        logger.info(value3);

        return "HELL-O";
    }
}
