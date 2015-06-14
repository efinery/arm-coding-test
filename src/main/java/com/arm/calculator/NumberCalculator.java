package com.arm.calculator;

public class NumberCalculator {

    public int calculate(String values) {
        int result = 0;
        if (!"".equals(values.trim())) {
            result = Integer.valueOf(values);
        }
        return result;
    }
}
