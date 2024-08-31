package com.incubyte.incubyte_calculator;

import static com.incubyte.incubyte_calculator.Constants.COMMA;

public class SimpleStringCal implements ICalculator {
    @Override
    public int add(String num) {
        if (num == null || num.isEmpty()) {
            return 0;
        }
        else if (num.length() == 1) {
            try {
                return Integer.parseInt(num);
            } catch (NumberFormatException exception) {
                return Integer.MAX_VALUE;
            }

        } else if (num.length() > 2 && num.contains(COMMA)) {
            String[] numbers = num.split(COMMA);
            try {
                return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
            } catch (NumberFormatException exception) {
                return Integer.MAX_VALUE;
            }
        }
        return 1;
    }
}
