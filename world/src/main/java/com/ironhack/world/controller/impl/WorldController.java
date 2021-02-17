package com.ironhack.world.controller.impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldController {
    @GetMapping("/world")
    public String world() {
        return " World :3";
    }
}
