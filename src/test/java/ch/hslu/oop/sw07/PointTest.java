package ch.hslu.oop.sw07;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    public void testPointEqualsTrue() {
        // Prepare
        int xP1 = 1;
        int yP1 = 2;
        Point point1 = new Point(xP1, yP1);

        int xP2 = 1;
        int yP2 = 2;
        Point point2 = new Point(xP2, yP2);

        // Act
        boolean result = point1.equals(point2);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testPointEqualsFalse() {
        // Prepare
        int xP1 = 1;
        int yP1 = 2;
        Point point1 = new Point(xP1, yP1);

        int xP2 = 3;
        int yP2 = 4;
        Point point2 = new Point(xP2, yP2);

        // Act
        boolean result = point1.equals(point2);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testEqualsVerifier() {
        EqualsVerifier.simple().forClass(Point.class).verify();
    }
}