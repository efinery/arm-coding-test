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

    @Test
    public void should_handle_single_number() {
        int result = calculator.calculate("1");
        assertEquals(1, result);
    }

    @Test
    public void should_handle_two_nubers() {
        int result = calculator.calculate("1\n2");
        assertEquals(3, result);
    }

    @Test
    public void should_handle_many_nubers() {
        int result = calculator.calculate("1\n2\n3\n100");
        assertEquals(106, result);
    }

    @Test
    public void should_handle_commas_and_newlines() {
        int result = calculator.calculate("1\n2,3");
        assertEquals(6, result);
    }
}