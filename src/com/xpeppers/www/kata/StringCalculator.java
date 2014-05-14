package com.xpeppers.www.kata;

public class StringCalculator {

    public static int add(String stringOfNumbers) {
        if (stringOfNumbers.isEmpty())
            return 0;

        String[] numbers = stringOfNumbers.split(",|\n");

        int sum = 0;
        for (String eachNumber : numbers) {
            sum += Integer.parseInt(eachNumber);
        }

        return sum;
    }

}
