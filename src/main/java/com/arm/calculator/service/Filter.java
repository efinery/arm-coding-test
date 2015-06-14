package com.arm.calculator.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class Filter {

    public List<Integer> filter(List<Integer> numbers) {
        List<Integer> results = new ArrayList<Integer>();
        List<Integer> negatives = new ArrayList<Integer>();

        for (Integer number : numbers) {
            if (number < 0) {
                negatives.add(number);
            } else if (number <= 1000) {
                results.add(number);
            }
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed : " + negatives);
        }
        return results;
    }
}
