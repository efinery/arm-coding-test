package com.arm.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Calculator {
    private final Parser parser;

    @Autowired
    public Calculator(Parser parser) {
        this.parser = parser;
    }

    public int add(String input) {
        List<Integer> numbers = parser.parse(input);
        int result = 0;

        for (Integer value : numbers) {
            result += value;
        }
        return result;
    }

}
