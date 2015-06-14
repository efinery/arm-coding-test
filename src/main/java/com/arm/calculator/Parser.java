package com.arm.calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.valueOf;

class Parser {
    private static final String DEFAULT_DELIMETER = "[\n|,]";

    public List<Integer> parse(String input) {
        List<Integer> results;

        if ("".equals(input)) {
            results = Collections.emptyList();
        } else {
            if (input.startsWith("//")) {
                String[] inputs = input.split("\n");
                String delimiter = inputs[0].substring(2);
                results = parseNumbers(inputs[1], delimiter);
            } else {
                results = parseNumbers(input, DEFAULT_DELIMETER);
            }
        }
        return results;
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
