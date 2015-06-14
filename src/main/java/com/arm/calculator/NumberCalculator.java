package com.arm.calculator;

public class NumberCalculator {
    private final Parser parser;

    public NumberCalculator(Parser parser) {
        this.parser = parser;
    }

    public int add(String input) {
        Context context = parser.parse(input);
        int result = 0;

        for (Integer value : context.getNumbers()) {
            result += value;
        }
        return result;
    }

}
