package com.xpeppers.www.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int add(String stringOfNumbers) throws Exception {
        String[] numbers = extractNumbersFrom(stringOfNumbers);

        return sum(numbers);
    }

    private static String[] extractNumbersFrom(String stringOfNumbers) {
        String delimitersRegexp = ",|\n";

        Matcher matcher = match(stringOfNumbers, "//(.+)\n(.*)");
        if (matcher.matches()) {
            delimitersRegexp = matcher.group(1);
            stringOfNumbers = matcher.group(2);
        }

        if (stringOfNumbers.isEmpty())
            return new String[0];

        return stringOfNumbers.split(delimitersRegexp);
    }

    private static int sum(String[] numbers) throws Exception {
        List<Integer> negativeNumbers = new ArrayList<Integer>();
        int sum = 0;
        for (String eachNumber : numbers) {
            int eachInteger = Integer.parseInt(eachNumber);
            if (eachInteger < 0) {
                negativeNumbers .add(eachInteger);
            }
            sum += eachInteger;
        }
        if (!negativeNumbers.isEmpty())
            throw new Exception("negatives not allowed: " + negativeNumbers);

        return sum;
    }

    private static Matcher match(String stringOfNumbers, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(stringOfNumbers);
    }

}
