package com.xpeppers.www.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Test
    public void emptyStringAddsToZero() {
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
    public void newlineIsAnAllowedNumberSeparator() throws Exception {
        assertEquals(6, StringCalculator.add("1,2\n3"));
    }

}
