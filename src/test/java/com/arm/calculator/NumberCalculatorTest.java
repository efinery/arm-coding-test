package com.arm.calculator;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class NumberCalculatorTest {
    private NumberCalculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new NumberCalculator();
    }

    @Test
    public void should_handle_empty_string() {
        int result = calculator.add("");
        assertEquals(0, result);
    }

    @Test
    public void should_handle_single_number() {
        int result = calculator.add("1");
        assertEquals(1, result);
    }

    @Test
    public void should_handle_two_nubers() {
        int result = calculator.add("1\n2");
        assertEquals(3, result);
    }

    @Test
    public void should_handle_many_nubers() {
        int result = calculator.add("1\n2\n3\n100");
        assertEquals(106, result);
    }

    @Test
    public void should_handle_commas_and_newlines() {
        int result = calculator.add("1\n2,3");
        assertEquals(6, result);
    }

    @Test
    public void should_handle_change_of_delimiter() {
        int result = calculator.add("//;\n1;2");
        assertEquals(3, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_fail_on_negative_number() {
        calculator.add("-1");
    }

    @Test
    public void should_show_negative_number_in_exception_message() {
        try {
            calculator.add("-1");
            fail("Should fail on negative number!");
        } catch (IllegalArgumentException e) {
            assertEquals("Negatives not allowed : [-1]", e.getMessage());
        }
    }

    @Test
    public void should_show_all_negative_numbers_in_exception_message() {
        try {
            calculator.add("1,-2,-3,4");
            fail("Should fail on negative number!");
        } catch (IllegalArgumentException e) {
            assertEquals("Negatives not allowed : [-2, -3]", e.getMessage());
        }
    }
}