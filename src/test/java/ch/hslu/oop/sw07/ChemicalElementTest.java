package ch.hslu.oop.sw07;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChemicalElementTest {

    @Test
    public void testChemicalElementEqualsTrue() {
        // Prepare
        Nitrogen nitrogen1 = new Nitrogen();
        Nitrogen nitrogen2 = new Nitrogen();

        // Act
        boolean result = nitrogen1.equals(nitrogen2);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testChemicalElementEqualsFalse() {
        // Prepare
        Nitrogen nitrogen = new Nitrogen();
        Oxygen oxygen = new Oxygen();

        // Act
        boolean result = nitrogen.equals(oxygen);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testEqualsVerifier() {
        EqualsVerifier.simple().forClass(ChemicalElement.class).verify();
    }

    @Test
    public void testCompareToEqual() {
        // Prepare
        Nitrogen nitrogen1 = new Nitrogen();
        Nitrogen nitrogen2 = new Nitrogen();

        // Act
        int result = nitrogen1.compareTo(nitrogen2);

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void testCompareToGreater() {
        // Prepare
        Nitrogen nitrogen = new Nitrogen();
        Oxygen oxygen = new Oxygen();

        // Act
        int result = nitrogen.compareTo(oxygen);

        // Assert
        assertEquals(1, result);
    }


    @Test
    public void testCompareToSmaller() {
        // Prepare
        Nitrogen nitrogen = new Nitrogen();
        Oxygen oxygen = new Oxygen();

        // Act
        int result = oxygen.compareTo(nitrogen);

        // Assert
        assertEquals(-1, result);
    }
}