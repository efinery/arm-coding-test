package com.arm.calculator.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.arm.calculator")
@SpringBootApplication
public class CalculatorApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CalculatorApplication.class, args);
    }

}
