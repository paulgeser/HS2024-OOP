package ch.hslu.oop.sw10.temperature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureCurveTest {


    TemperatureCurve temperatureCurve;

    private Temperature maxTemperature;
    private Temperature minTemperature;

    @BeforeEach
    void prepareTest() {
        this.maxTemperature = null;
        this.minTemperature = null;
        this.temperatureCurve = new TemperatureCurve();

        this.temperatureCurve.addPropertyChangeListener(this::handleTemperatureCurveEvent);
    }

    @Test
    void testEmptyState() {
        // assert
        assertNull(this.maxTemperature);
        assertNull(this.minTemperature);
    }

    @Test
    void testAddOneTemperature() {
        // arrange
        Temperature temperature = Temperature.createFromCelsius(20);

        // act
        this.temperatureCurve.addTemperature(temperature);

        // assert
        assertEquals(temperature, this.minTemperature);
        assertEquals(temperature, this.maxTemperature);
        assertEquals(1, this.temperatureCurve.getCount());
    }

    @Test
    void testAddTwoTemperatures() {
        // arrange
        Temperature temperature1 = Temperature.createFromCelsius(20);
        Temperature temperature2 = Temperature.createFromCelsius(23);

        // act
        this.temperatureCurve.addTemperature(temperature1);
        this.temperatureCurve.addTemperature(temperature2);

        // assert
        assertEquals(temperature1, this.minTemperature);
        assertEquals(temperature2, this.maxTemperature);
        assertEquals(2, this.temperatureCurve.getCount());
    }

    @Test
    void testAddFourTemperatures() {
        // arrange
        Temperature temperature1 = Temperature.createFromCelsius(20);
        Temperature temperature2 = Temperature.createFromCelsius(23);
        Temperature temperature3 = Temperature.createFromCelsius(22.99);
        Temperature temperature4 = Temperature.createFromCelsius(19.8);


        // act
        this.temperatureCurve.addTemperature(temperature1);
        this.temperatureCurve.addTemperature(temperature2);
        this.temperatureCurve.addTemperature(temperature3);
        this.temperatureCurve.addTemperature(temperature4);

        // assert
        assertEquals(temperature4, this.minTemperature);
        assertEquals(temperature2, this.maxTemperature);
        assertEquals(4, this.temperatureCurve.getCount());
    }

    void handleTemperatureCurveEvent(TemperatureEventInterface event) {
        this.testIfTemperatureExists(event.getNewValue());
        if (event.getEventType() == EventType.MAX) {
            this.maxTemperature = event.getNewValue();
        } else {
            this.minTemperature = event.getNewValue();
        }
    }

    void testIfTemperatureExists(Temperature inputTemperature) {
        Collection<Temperature> temperatureList = this.temperatureCurve.getTemperatureList();
        List<Temperature> filteredTemperatureList = temperatureList.stream().filter(temperature -> temperature.equals(inputTemperature)).toList();
        assertEquals(1, filteredTemperatureList.size());
    }
}