package com.arm.calculator;

class Parser {
    private static final String DEFAULT_DELIMETER = "[\n|,]";

    public Context parse(String input) {
        Context context;
        if (input.startsWith("//")) {
            String[] inputs = input.split("\n");
            String delimiter = inputs[0].substring(2);
            context = new Context(delimiter, inputs[1]);
        } else {
            context = new Context(DEFAULT_DELIMETER, input);
        }
        return context;
    }
}
