package com.ironhack.helloworldhystrix.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("world-service")
public interface WorldClient {
    @GetMapping("/world")
    String world();
}
