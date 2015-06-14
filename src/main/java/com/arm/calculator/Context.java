package com.arm.calculator;

class Context {
    private final String delimeter;
    private final String input;

    public Context(String delimeter, String input) {
        this.delimeter = delimeter;
        this.input = input;
    }

    public String getDelimeter() {
        return delimeter;
    }

    public String getInput() {
        return input;
    }
}
