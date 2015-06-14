package com.arm.calculator;

public class NumberCalculator {

    public int calculate(String input) {
        int result = 0;
        if (!"".equals(input.trim())) {
            String[] numbers = input.split(",");
            for (String number : numbers) {
                result += Integer.valueOf(number);
            }
        }
        return result;
    }
}
