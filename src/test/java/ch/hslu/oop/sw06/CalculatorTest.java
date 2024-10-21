package ch.hslu.oop.sw06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calc;

    @BeforeEach
    void prepare() {
        this.calc = new Calculator();
    }

    @Test
    void testZeroAddition() {
        // Prepare
        double a = 0;
        double b = 0;

        // Act
        double result = this.calc.addidition(a, b);

        // Assert
        assertEquals(result, 0);
    }

    @Test
    void testZeroPlusPositive() {
        // Prepare
        double a = 0;
        double b = 5;

        // Act
        double result = this.calc.addidition(a, b);

        // Assert
        assertEquals(result, 5);
    }

    @Test
    void testPositivePlusPositive() {
        // Prepare
        double a = 3;
        double b = 5;

        // Act
        double result = this.calc.addidition(a, b);

        // Assert
        assertEquals(result, 8);
    }

    @Test
    void testFloatingNumberAddition() {
        // Prepare
        double a = 3.6;
        double b = 5.1;

        // Act
        double result = this.calc.addidition(a, b);

        // Assert
        assertEquals(result, 8.7);
    }

    @Test
    void testPositivePlusNegative() {
        // Prepare
        double a = 4;
        double b = -7;

        // Act
        double result = this.calc.addidition(a, b);

        // Assert
        assertEquals(result, -3);
    }

    @Test
    void testNegativePlusNegative() {
        // Prepare
        double a = -4;
        double b = -7;

        // Act
        double result = this.calc.addidition(a, b);

        // Assert
        assertEquals(result, -11);
    }
}