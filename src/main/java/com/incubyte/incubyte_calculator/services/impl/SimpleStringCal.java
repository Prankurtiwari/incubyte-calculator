package com.incubyte.incubyte_calculator.services.impl;

import com.incubyte.incubyte_calculator.services.ICalculator;

import java.util.regex.Pattern;

import static com.incubyte.incubyte_calculator.constants.Constants.COMMA;
import static com.incubyte.incubyte_calculator.constants.Constants.NEW_LINE;

public class SimpleStringCal implements ICalculator {

    private static boolean isDelimiterInput(String str) {
        return str.length() >= 3 && str.charAt(0) == '/' && str.charAt(1) == '/';
    }
    private String getDelimiter(String str) {
        return isDelimiterInput(str) ? str.substring(2, str.indexOf(NEW_LINE)) : COMMA;
    }

    private String getActualString(String str) {
        return isDelimiterInput(str) ? str.substring(str.indexOf(NEW_LINE)+1) : str;
    }


    @Override
    public int add(String num) {
        if (num == null || num.isEmpty()) {
            return 0;
        }
        int sum = 0;
        String delimiter = getDelimiter(num);
        num = getActualString(num);

        if (num.length() == 1 && Character.isDigit(num.charAt(0))) {
            return Integer.parseInt(num.trim());
        }

        if (num.length() > 1 && num.contains(delimiter)) {
            String[] numbers = num.split(Pattern.quote(delimiter));
            for (String number: numbers) {
                sum += Integer.parseInt(number.trim());
            }
        }
        return sum;
    }
}
