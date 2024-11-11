package ch.hslu.oop.Sw09;

import ch.hslu.oop.sw09.Temperature;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureTest {

    @Test
    public void testTemperatureConstructorSet() {
        // Arrange
        int temperature = 27;

        // Act
        Temperature t = Temperature.createFromCelsius(temperature);
        double result = t.getTemperatureCelcius();

        // Assert
        assertEquals(27, result);
    }

    @Test
    public void testTemperatureConstructorSetKelvin() {
        // Arrange
        double temperature = 300.15;
        double expectedResult = 300.15;

        // Act
        Temperature t = Temperature.createFromKelvin(temperature);
        double result = t.getTemperaturKelvin();

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void testTemperatureConstructorSetFahrenheit() {
        // Arrange
        int temperature = 27;
        double expectedResult = 80.6;

        // Act
        Temperature t = Temperature.createFromCelsius(temperature);
        double result = t.getTemperaturFahrenheit();

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void testTemperatureIncreaseCero() {
        // Arrange
        int temperature = 27;

        // Act
        Temperature t = Temperature.createFromCelsius(temperature);
        t.increaseTemperature(0);
        double result = t.getTemperatureCelcius();

        // Assert
        assertEquals(temperature, result);
    }

    @Test
    public void testTemperatureIncrease() {
        // Arrange
        int temperature = 27;
        int increaseValue = 2;

        // Act
        Temperature t = Temperature.createFromCelsius(temperature);
        t.increaseTemperature(increaseValue);
        double result = t.getTemperatureCelcius();

        // Assert
        assertEquals(temperature + increaseValue, result);
    }

    @Test
    public void testTemperatureDecreaseCero() {
        // Arrange
        int temperature = 27;

        // Act
        Temperature t = Temperature.createFromCelsius(temperature);
        t.decreaseTemperature(0);
        double result = t.getTemperatureCelcius();

        // Assert
        assertEquals(temperature, result);
    }

    @Test
    public void testTemperatureDecrease() {
        // Arrange
        int temperature = 27;
        int decreaseValue = 2;
        // Act
        Temperature t = Temperature.createFromCelsius(temperature);
        t.decreaseTemperature(decreaseValue);
        double result = t.getTemperatureCelcius();

        // Assert
        assertEquals(temperature - decreaseValue, result);
    }

    @Test
    public void testTemperatureEqualsTrue() {
        // Arrange
        int temp1 = 45;
        Temperature temperature1 = Temperature.createFromCelsius(temp1);

        int temp2 = 45;
        Temperature temperature2 = Temperature.createFromCelsius(temp2);

        // Act
        boolean result = temperature1.equals(temperature2);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testTemperatureEqualsFalse() {
        // Arrange
        int temp1 = 35;
        Temperature temperature1 = Temperature.createFromCelsius(temp1);

        int temp2 = 45;
        Temperature temperature2 = Temperature.createFromCelsius(temp2);

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
        // Arrange
        Temperature temperature1 = Temperature.createFromCelsius(100);
        Temperature temperature2 = Temperature.createFromCelsius(100);

        // Act
        int result = temperature1.compareTo(temperature2);

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void testCompareToGreater() {
        // Arrange
        Temperature temperature1 = Temperature.createFromCelsius(100);
        Temperature temperature2 = Temperature.createFromCelsius(101);

        // Act
        int result = temperature1.compareTo(temperature2);

        // Assert
        assertEquals(-1, result);
    }


    @Test
    public void testCompareToSmaller() {
        // Arrange
        Temperature temperature1 = Temperature.createFromCelsius(100);
        Temperature temperature2 = Temperature.createFromCelsius(99);

        // Act
        int result = temperature1.compareTo(temperature2);

        // Assert
        assertEquals(1, result);
    }

    @Test
    public void testStaticConvertToKelvin() {
        // Arrange
        double celsius = 27;
        double kelvin = 300.15;
        Temperature t = Temperature.createFromCelsius(0);

        // Act
        double result = t.convertCelsiusToKelvin(celsius);

        // Assert
        assertEquals(kelvin, result);
    }

    @Test
    public void testStaticConvertToCelsuis() {
        // Arrange
        double celsius = 27;
        double kelvin = 300.15;
        Temperature t = Temperature.createFromCelsius(0);

        // Act
        double result = t.convertKelvinToCelsius(kelvin);

        // Assert
        assertEquals(celsius, result);
    }

    @Test
    public void testCreateTemperatureWithValidCelsius() {
        // Arrange
        double celsius = -270;

        // Act
        Temperature t = Temperature.createFromCelsius(celsius);

        // Assert
        assertEquals(celsius, t.getTemperatureCelcius());
    }

    @Test
    public void testCreateTemperatureWithInvalidCelsius() {
        // Arrange
        double celsius = -275;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            Temperature.createFromCelsius(celsius);
        });
    }

    @Test
    public void testCreateTemperatureWithValidKelvin() {
        // Arrange
        double kelvin = 3;
        boolean error = false;
        String errorMessage = "";

        // Act
        Temperature t = Temperature.createFromKelvin(kelvin);


        // Assert
        assertEquals(kelvin, t.getTemperaturKelvin());
    }

    @Test
    public void testCreateTemperatureWithInvalidKelvin() {
        // Arrange
        double kelvin = -3;
        boolean error = false;
        String errorMessage = "";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            Temperature.createFromKelvin(kelvin);
        });
    }
}