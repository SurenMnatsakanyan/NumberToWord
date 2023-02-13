package com.example.myapplication;

import java.util.Arrays;
import java.util.List;

public class NumberToEnglishConverter {
    private static final List<String> ONES = Arrays.asList(
            "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    );

    private static final List<String> TEN_TO_TWENTY = Arrays.asList("ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen");
    private static final List<String> TENS = Arrays.asList(
            "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety");


    public static String convert(int number) {
        if (number == 0) return "zero";

        StringBuilder result = new StringBuilder();
        int[] digits = new int[]{number % 1000, (number / 1000) % 1000, (number / 1_000_000) % 1000, (number / 1_000_000_000)};

        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            if (digit == 0) continue;

            if (digit >= 100) {
                result.append(ONES.get(digit / 100 - 1));
                result.append(" hundred ");
            }

            int tensAndOnes = digit % 100;
            if (tensAndOnes < 10) result.append(ONES.get(tensAndOnes - 1));
            else if (tensAndOnes < 20) result.append(TEN_TO_TWENTY.get(tensAndOnes - 10));
            else {
                result.append(TENS.get(tensAndOnes / 10 - 1));
                if (tensAndOnes % 10 != 0)
                    result.append(" ").append(ONES.get(tensAndOnes % 10 - 1));
            }

            if (i == 3) result.append(" thousand ");
            if (i == 2) result.append(" million ");
            if (i == 1) result.append(" thousand ");
        }

        return result.toString().trim();
    }
}
