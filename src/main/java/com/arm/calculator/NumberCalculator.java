package com.arm.calculator;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.valueOf;

public class NumberCalculator {

    public int add(String input) {
        Context context = new Parser().parse(input);
        int result = 0;

        if (!"".equals(context.getInput())) {
            String[] numbers = context.getInput().split(context.getDelimeter());
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
