package com.arm.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberCalculatorTest {
    private NumberCalculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new NumberCalculator();
    }

    @Test
    public void should_handle_empty_string() {
        int result = calculator.calculate("");
        assertEquals(0, result);
    }
}