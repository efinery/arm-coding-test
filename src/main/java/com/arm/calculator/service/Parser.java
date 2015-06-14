package com.arm.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.valueOf;

@Service
class Parser {
    private static final String DEFAULT_DELIMITER = "[\n,]";
    private final Filter filter;

    @Autowired
    Parser(Filter filter) {
        this.filter = filter;
    }

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
        return filter.filter(results);
    }

    private List<Integer> parseNumbers(String numberString, String delimiter) {
        List<Integer> results = new ArrayList<Integer>();

        String[] numbers = numberString.split(delimiter);
        for (String number : numbers) {
            int value = valueOf(number);
            results.add(value);
        }
        return results;
    }
}
