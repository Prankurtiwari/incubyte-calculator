package com.incubyte.incubyte_calculator;

import static com.incubyte.incubyte_calculator.Constants.COMMA;

public class SimpleStringCal implements ICalculator {
    @Override
    public int add(String num) {
        if (num == null || num.isEmpty()) {
            return 0;
        }
        int sum = 0;
        if (num.length() > 1 && num.contains(COMMA)) {
            String[] numbers = num.split(COMMA);
            for (String number: numbers) {
                sum += Integer.parseInt(number);
            }
        }
        return sum;
    }
}
