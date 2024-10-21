package ch.hslu.oop.sw06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxMinTest {

    @Test
    void testMaxRight() {
        // Prepare
        MaxMin maxMin = new MaxMin();

        // Act
        int result = maxMin.max(2, 1);

        // Assert
        assertEquals(2, result);
    }

    @Test
    void testMaxLeft() {
        // Prepare
        MaxMin maxMin = new MaxMin();

        // Act
        int result = maxMin.max(1, 2);

        // Assert
        assertEquals(2, result);
    }

    @Test
    void testMaxEqual() {
        // Prepare
        MaxMin maxMin = new MaxMin();

        // Act
        int result = maxMin.max(3, 3);

        // Assert
        assertEquals(3, result);
    }
}