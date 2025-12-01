package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RestApiController {

    @GetMapping("/api/greet")
    public Map<String, String> greet(@RequestParam(defaultValue = "world") String name) {
        return Map.of("message", "Hello, " + name + " from Java REST!");
    }
}