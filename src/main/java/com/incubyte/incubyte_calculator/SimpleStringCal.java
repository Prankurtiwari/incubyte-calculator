package com.incubyte.incubyte_calculator;

public class SimpleStringCal implements ICalculator {
    @Override
    public int add(String num) {
        if (num == null || num.isEmpty()) {
            return 0;
        }
        if (num.length() == 1) {
            try {
                return Integer.parseInt(num);
            } catch (NumberFormatException exception) {
                return Integer.MAX_VALUE;
            }

        }
        return 1;
    }
}
