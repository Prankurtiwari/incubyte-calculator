package com.incubyte.incubyte_calculator.exceptions;

import java.util.ArrayList;
import java.util.Arrays;

public class NegativeNumberException extends RuntimeException{
    public NegativeNumberException(ArrayList<Integer> numbers, String msg) {
        super(msg + Arrays.toString(numbers.toArray()));
    }
    public NegativeNumberException(Integer number, String msg) {
        super(msg + number);
    }
}
