package ch.hslu.oop.sw08;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureCurveTest {

    @Test
    void testAddTemperatureOne() {
        // Arrange
        TemperatureCurve temperatureCurve = new TemperatureCurve();
        Temperature temperature1 = new Temperature(1.0);

        // Act
        temperatureCurve.addTemperature(temperature1);

        // Assert
        assertEquals(1, temperatureCurve.getCount());
    }

    @Test
    void testAddTemperatureTwo() {
        // Arrange
        TemperatureCurve temperatureCurve = new TemperatureCurve();
        Temperature temperature1 = new Temperature(1.0);
        Temperature temperature2 = new Temperature(2.0);

        // Act
        temperatureCurve.addTemperature(temperature1);
        temperatureCurve.addTemperature(temperature2);

        // Assert
        assertEquals(2, temperatureCurve.getCount());
    }

    @Test
    void testTemperatureClear() {
        // Arrange
        TemperatureCurve temperatureCurve = new TemperatureCurve();
        Temperature temperature1 = new Temperature(1.0);
        Temperature temperature2 = new Temperature(2.0);
        temperatureCurve.addTemperature(temperature1);
        temperatureCurve.addTemperature(temperature2);
        assertEquals(2, temperatureCurve.getCount());

        // Act
        temperatureCurve.clear();

        // Assert
        assertEquals(0, temperatureCurve.getCount());
    }

    @Test
    void testGetMaxTemperature() {
        // Arrange
        TemperatureCurve temperatureCurve = new TemperatureCurve();
        Temperature temperature1 = new Temperature(1.0);
        Temperature temperature2 = new Temperature(6.0);
        Temperature temperature3 = new Temperature(-3.0);
        Temperature temperature4 = new Temperature(5.0);
        temperatureCurve.addTemperature(temperature1);
        temperatureCurve.addTemperature(temperature2);
        temperatureCurve.addTemperature(temperature3);
        temperatureCurve.addTemperature(temperature4);

        // Act
        Temperature result = temperatureCurve.getMaxTemperature();

        // Assert
        assertEquals(6.0, result.getTemperatureCelcius());
    }

    @Test
    void testGetMinTemperature() {
        // Arrange
        TemperatureCurve temperatureCurve = new TemperatureCurve();
        Temperature temperature1 = new Temperature(1.0);
        Temperature temperature2 = new Temperature(6.0);
        Temperature temperature3 = new Temperature(-3.0);
        Temperature temperature4 = new Temperature(5.0);
        temperatureCurve.addTemperature(temperature1);
        temperatureCurve.addTemperature(temperature2);
        temperatureCurve.addTemperature(temperature3);
        temperatureCurve.addTemperature(temperature4);

        // Act
        Temperature result = temperatureCurve.getMinTemperature();

        // Assert
        assertEquals(-3.0, result.getTemperatureCelcius());
    }

    @Test
    void testGetAverageCelsiusTemperature() {
        // Arrange
        TemperatureCurve temperatureCurve = new TemperatureCurve();
        Temperature temperature1 = new Temperature(1.0);
        Temperature temperature2 = new Temperature(6.0);
        Temperature temperature3 = new Temperature(-3.0);
        Temperature temperature4 = new Temperature(5.0);
        temperatureCurve.addTemperature(temperature1);
        temperatureCurve.addTemperature(temperature2);
        temperatureCurve.addTemperature(temperature3);
        temperatureCurve.addTemperature(temperature4);

        // Act
        double result = temperatureCurve.getAverageCelciusTemperature();

        // Assert
        assertEquals(2.25, result);
    }

    @Test
    void testGetMaxTemperatureNoValue() {
        // Arrange
        TemperatureCurve temperatureCurve = new TemperatureCurve();

        // Act
        Temperature result = temperatureCurve.getMaxTemperature();

        // Assert
        assertEquals(null, result);
    }

    @Test
    void testGetMinTemperatureNoValue() {
        // Arrange
        TemperatureCurve temperatureCurve = new TemperatureCurve();

        // Act
        Temperature result = temperatureCurve.getMinTemperature();

        // Assert
        assertEquals(null, result);
    }

    @Test
    void testGetAverageCelsiusTemperatureCero() {
        // Arrange
        TemperatureCurve temperatureCurve = new TemperatureCurve();

        // Act
        double result = temperatureCurve.getAverageCelciusTemperature();

        // Assert
        assertEquals(NaN, result);
    }
}