package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import javax.xml.ws.Endpoint;
import com.example.soap.CalculatorServiceImpl;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // Publish a simple JAX-WS SOAP endpoint on startup
    @PostConstruct
    public void publishSoap() {
        String address = "http://0.0.0.0:8080/ws/Calculator";
        Endpoint.publish(address, new CalculatorServiceImpl());
        System.out.println("Published SOAP endpoint at " + address);
    }
}