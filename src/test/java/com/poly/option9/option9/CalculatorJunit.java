package com.poly.option9.option9;

public class CalculatorJunit {

    public Integer add(int number1, int number2) {
        return number1 + number2;
    }

    // addWrong correct
    public Integer addWrong(int number1, int number2) {
        return 0;
    }

    public Integer subtract(int number1, int number2) {
        return number1 - number2;
    }

    public Integer multiply(int number1, int number2) {
        return number1 * number2;
    }

    public Integer divide(int number1, int number2) {
        if (number2 == 0) {
            return null;
        }
        return number1 / number2;
    }

    public Integer divide5(int number1, int number2) {
        if (number2 == 0) {
            throw new ArithmeticException("The second number must not be zero");
        }
        return number1 / number2;
    }

    public void validateNumber(Integer number1, Integer number2) {
        if (number1 == null || number2 == null) {
            throw new NullPointerException("Either of the two numbers is null.");
        }
    }

    public double VaxCalculator(Double amount) {
        return amount * 0.1;
    }

}
