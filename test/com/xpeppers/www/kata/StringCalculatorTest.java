package com.xpeppers.www.kata;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Test
    public void emptyStringAddsToZero() throws Exception {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void stringWithOneNumberAddsTheSameNumber() throws Exception {
        assertEquals(3, StringCalculator.add("3"));
    }

    @Test
    public void stringWithAnyAmountOfNumbersSeparatedByCommasAddsToTheSumOfAllTheNumbers() throws Exception {
        assertEquals(10, StringCalculator.add("1,2,3,4"));
    }

    @Test
    public void newlineIsAnAllowedNumberDelimiter() throws Exception {
        assertEquals(6, StringCalculator.add("1,2\n3"));
    }

    @Test
    public void supportsCustomDelimiters() throws Exception {
        assertEquals(3, StringCalculator.add("//;\n1;2"));
    }

    @Test
    public void stringWithCustomerDelimiterAndNoNumersAddsToZero() throws Exception {
        assertEquals(0, StringCalculator.add("//;\n"));
    }

    @Test
    public void throwsExceptionForNegativeNumbers() throws Exception {
        try {
            StringCalculator.add("1,2,-3");
            fail("Should never reach this line!");
        } catch (Exception e) {
        }
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void throwsExceptionForNegativeNumbersWithProperMessage() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("negatives not allowed: -3");

        StringCalculator.add("1,2,-3");
    }

}
