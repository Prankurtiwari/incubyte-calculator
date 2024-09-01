package com.incubyte.incubyte_calculator.services.impl;

import com.incubyte.incubyte_calculator.exceptions.NegativeNumberException;
import com.incubyte.incubyte_calculator.services.ICalculator;

import java.util.ArrayList;
import java.util.regex.Pattern;

import static com.incubyte.incubyte_calculator.constants.Constants.*;

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
    public int add(String num) throws NegativeNumberException {
        if (num == null || num.isEmpty()) {
            return 0;
        }
        int sum = 0;
        String delimiter = getDelimiter(num);
        num = getActualString(num);

        if (num.length() == 1 && Character.isDigit(num.charAt(0))) {
            return Integer.parseInt(num.trim());
        }

        if (num.length() > 1 && num.charAt(0) == '-') {
            int number = Integer.parseInt(num.trim());
            if (number < 0)
                throw new NegativeNumberException(number, ERROR_MSG);
            return number;
        }


        boolean isNegativeNumberPresent = false;
        ArrayList<Integer> negatives = new ArrayList<>();
        if (num.length() > 1 && num.contains(delimiter)) {
            String[] numbers = num.split(Pattern.quote(delimiter));
            for (String number: numbers) {
                int parsed = Integer.parseInt(number.trim());
                if (parsed < 0) {
                    isNegativeNumberPresent = true;
                    negatives.add(parsed);
                }
                if (parsed > LIMIT) {
                    continue;
                }
                sum += parsed;
            }
        }
        if (isNegativeNumberPresent) {
            throw new NegativeNumberException(negatives, ERROR_MSG);
        }
        return sum;
    }
}
