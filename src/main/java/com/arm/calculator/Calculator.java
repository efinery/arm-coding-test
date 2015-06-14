package com.arm.calculator;

import java.util.List;

public class Calculator {
    private final Parser parser;

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
