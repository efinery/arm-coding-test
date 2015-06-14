package com.arm.calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.valueOf;

class Parser {
    private static final String DEFAULT_DELIMETER = "[\n|,]";
    private static final Context EMPTY_CONTEXT = new Context("", Collections.EMPTY_LIST);

    public Context parse(String input) {
        Context context;
        if ("".equals(input)) {
            context = EMPTY_CONTEXT;
        } else {
            if (input.startsWith("//")) {
                String[] inputs = input.split("\n");
                String delimiter = inputs[0].substring(2);
                List<Integer> numbers = parseNumbers(inputs[1], delimiter);
                context = new Context(delimiter, numbers);
            } else {
                List<Integer> numbers = parseNumbers(input, DEFAULT_DELIMETER);
                context = new Context(DEFAULT_DELIMETER, numbers);
            }
        }
        return context;
    }

    private List<Integer> parseNumbers(String numberString, String delimeter) {
        String[] numbers = numberString.split(delimeter);
        List<Integer> results = new ArrayList<Integer>();
        List<Integer> negatives = new ArrayList<Integer>();
        for (String number : numbers) {
            int value = valueOf(number);
            if (value < 0) {
                negatives.add(value);
            } else {
                results.add(value);
            }
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed : " + negatives);
        }
        return results;
    }
}
