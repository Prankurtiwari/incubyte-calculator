package com.incubyte.incubyte_calculator.services;

import com.incubyte.incubyte_calculator.exceptions.NegativeNumberException;

public interface ICalculator {
    int add (String num) throws NegativeNumberException;
}
