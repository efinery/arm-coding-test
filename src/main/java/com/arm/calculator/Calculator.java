package com.arm.calculator;

import java.util.List;

public class Calculator {
    private final Parser parser;
    private final Filter filter;

    public Calculator(Parser parser, Filter filter) {
        this.parser = parser;
        this.filter = filter;
    }

    public int add(String input) {
        List<Integer> allNumbers = parser.parse(input);
        List<Integer> numbers = filter.filter(allNumbers);
        int result = 0;

        for (Integer value : numbers) {
            result += value;
        }
        return result;
    }

}
