package com.arm.calculator;

import java.util.ArrayList;
import java.util.List;

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
            List<Integer> negatives = new ArrayList<Integer>();
            for (String number : numbers) {
                int value = valueOf(number);
                if (value < 0) {
                    negatives.add(value);
                } else {
                    result += value;
                }
            }
            if (!negatives.isEmpty()) {
                throw new IllegalArgumentException("Negatives not allowed : " + negatives);
            }
        }
        return result;
    }

}
