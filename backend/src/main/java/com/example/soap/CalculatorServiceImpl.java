package com.example.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService(serviceName = "CalculatorService")
public class CalculatorServiceImpl {

    @WebMethod
    public int add(int a, int b) {
        return a + b;
    }

    @WebMethod
    public int subtract(int a, int b) {
        return a - b;
    }
}