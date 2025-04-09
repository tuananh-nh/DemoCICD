package com.poly.option9.option9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorJunitTest {
    CalculatorJunit calculatorJunit = new CalculatorJunit();

    @Test
    public void testConditionEquals() {
        Integer equalsTest = calculatorJunit.multiply(5, 3);
        Assertions.assertEquals(15, (int) equalsTest);
    }

    @Test
    public void testConditionNotEquals() {
        Integer equalsTest = calculatorJunit.add(10, 9);
        Assertions.assertNotEquals(5, (int) equalsTest);
    }

    @Test
    public void testConditionCorrect() {
        boolean correctTest = calculatorJunit.subtract(24, 5).equals(19);
        Assertions.assertTrue(correctTest);
    }

    @Test
    public void testConditionUnCorrect() {
        boolean correctTest = calculatorJunit.divide(75, 5).equals(25);
        Assertions.assertFalse(correctTest);
    }

    @Test
    public void testConditionIsNull() {
        Integer correctTest = calculatorJunit.divide(15, 0);
        System.out.println(correctTest);
        Assertions.assertNull(correctTest);
    }
}
