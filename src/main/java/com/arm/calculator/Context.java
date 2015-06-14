package com.arm.calculator;

import java.util.List;

class Context {
    private final String delimeter;
    private final List<Integer> numbers;

    public Context(String delimeter, List<Integer> numbers) {
        this.delimeter = delimeter;
        this.numbers = numbers;
    }

    public String getDelimeter() {
        return delimeter;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
