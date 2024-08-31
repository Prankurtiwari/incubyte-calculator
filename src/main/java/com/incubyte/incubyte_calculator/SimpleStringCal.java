package com.incubyte.incubyte_calculator;

public class SimpleStringCal implements ICalculator {
    @Override
    public int add(String num) {
        if (num == null || num.isEmpty()) {
            return 0;
        }
        return 1;
    }
}
