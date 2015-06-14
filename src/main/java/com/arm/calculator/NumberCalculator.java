package com.arm.calculator;

import static java.lang.Integer.valueOf;

public class NumberCalculator {

    public int add(String input) {
        String delimiter = "[\n|,]";
        int result = 0;

        if (!"".equals(input)) {
            if (input.startsWith("//")) {
                String[] inputs = input.split("\n");
                delimiter = inputs[0].substring(2);
                input = inputs[1];
            }
            String[] numbers = input.split(delimiter);
            for (String number : numbers) {
                int value = valueOf(number);
                if (value < 0) {
                    throw new IllegalArgumentException("Negatives not allowed : " + value);
                }
                result += value;
            }
        }
        return result;
    }
}
