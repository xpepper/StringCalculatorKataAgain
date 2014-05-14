package com.xpeppers.www.kata;

public class StringCalculator {

    public static int add(String stringOfNumbers) {
        if (stringOfNumbers.isEmpty())
            return 0;

        String[] split = null;
        String customDelimiter = null;
        if (stringOfNumbers.startsWith("//")) {
            split = stringOfNumbers.split("\n", 2);
            customDelimiter = split[0].substring(2, split[0].length());
            stringOfNumbers = split[1];
        }

        String defaultDelimiters = ",|\n";
        if (customDelimiter != null)
            defaultDelimiters = customDelimiter;
        String[] numbers = stringOfNumbers.split(defaultDelimiters);

        int sum = 0;
        for (String eachNumber : numbers) {
            sum += Integer.parseInt(eachNumber);
        }

        return sum;
    }

}
