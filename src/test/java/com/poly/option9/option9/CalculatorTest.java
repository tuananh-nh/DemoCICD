package com.poly.option9.option9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    CalculatorJunit calculatorJunit = new CalculatorJunit();

    @Test
    public void testConditionNotEquals() {
        Integer equalsTest = calculatorJunit.add(10, 9);
        Assertions.assertNotEquals(5, (int) equalsTest);
    }

    @Test
    public void testConditionEquals() {
        Integer equalsTest = calculatorJunit.addWrong(7, 3);
        Assertions.assertEquals(10, (int) equalsTest);
    }
}
