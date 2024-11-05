package ch.hslu.oop.sw08;

import ch.hslu.oop.sw08.ChemicalElement;
import ch.hslu.oop.sw08.Nitrogen;
import ch.hslu.oop.sw08.Oxygen;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChemicalElementTest {

    @Test
    public void getSolidElementState() {
        // Arrange
        Oxygen oxygen = new Oxygen();
        double temperature = -223.2;

        // Act
        AggregationState result = oxygen.evaluateState(temperature);

        // Assert
        assertEquals(AggregationState.SOLID, result);
    }

    @Test
    public void getSolidDescriptionElementState() {
        // Arrange
        Oxygen oxygen = new Oxygen();
        double temperature = -223.2;

        // Act
        AggregationState result = oxygen.evaluateState(temperature);

        // Assert
        assertEquals("fest", result.getDescription());
    }

    @Test
    public void getLiquidElementState() {
        // Arrange
        Oxygen oxygen = new Oxygen();
        double temperature = -193.2;

        // Act
        AggregationState result = oxygen.evaluateState(temperature);

        // Assert
        assertEquals(AggregationState.LIQUID, result);
    }

    @Test
    public void getLiquidDescriptionElementState() {
        // Arrange
        Oxygen oxygen = new Oxygen();
        double temperature = -193.2;

        // Act
        AggregationState result = oxygen.evaluateState(temperature);

        // Assert
        assertEquals("flüssig", result.getDescription());
    }

    @Test
    public void getGasElementState() {
        // Arrange
        Oxygen oxygen = new Oxygen();
        double temperature = -93.2;

        // Act
        AggregationState result = oxygen.evaluateState(temperature);

        // Assert
        assertEquals(AggregationState.GAS, result);
    }

    @Test
    public void getGasDescriptionElementState() {
        // Arrange
        Oxygen oxygen = new Oxygen();
        double temperature = -93.2;

        // Act
        AggregationState result = oxygen.evaluateState(temperature);

        // Assert
        assertEquals("gasförmig", result.getDescription());
    }
}