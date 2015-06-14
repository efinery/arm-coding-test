package com.arm.calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.valueOf;

class Parser {
    private static final String DEFAULT_DELIMITER = "[\n|,]";

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
                results = parseNumbers(input, DEFAULT_DELIMITER);
            }
        }
        return results;
    }

    private List<Integer> parseNumbers(String numberString, String delimiter) {
        String[] numbers = numberString.split(delimiter);
        List<Integer> results = new ArrayList<Integer>();

        for (String number : numbers) {
            int value = valueOf(number);
            results.add(value);
        }
        return results;
    }
}
