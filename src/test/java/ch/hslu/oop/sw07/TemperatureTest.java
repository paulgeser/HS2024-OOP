package ch.hslu.oop.sw07;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {

    @Test
    public void testTemperatureEqualsTrue() {
        // Prepare
        int temp1 = 45;
        Temperature temperature1 = new Temperature(temp1);

        int temp2 = 45;
        Temperature temperature2 = new Temperature(temp2);

        // Act
        boolean result = temperature1.equals(temperature2);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testTemperatureEqualsFalse() {
        // Prepare
        int temp1 = 35;
        Temperature temperature1 = new Temperature(temp1);

        int temp2 = 45;
        Temperature temperature2 = new Temperature(temp2);

        // Act
        boolean result = temperature1.equals(temperature2);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testEqualsVerifier() {
        EqualsVerifier.simple().forClass(Temperature.class).verify();
    }

    @Test
    public void testCompareToEqual() {
        // Prepare
        Temperature temperature1 = new Temperature(100);
        Temperature temperature2 = new Temperature(100);

        // Act
        int result = temperature1.compareTo(temperature2);

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void testCompareToGreater() {
        // Prepare
        Temperature temperature1 = new Temperature(100);
        Temperature temperature2 = new Temperature(101);

        // Act
        int result = temperature1.compareTo(temperature2);

        // Assert
        assertEquals(-1, result);
    }


    @Test
    public void testCompareToSmaller() {
        // Prepare
        Temperature temperature1 = new Temperature(100);
        Temperature temperature2 = new Temperature(99);

        // Act
        int result = temperature1.compareTo(temperature2);

        // Assert
        assertEquals(1, result);
    }
}