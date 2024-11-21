package ch.hslu.oop.sw10;

import ch.hslu.oop.sw10.car.Car;
import ch.hslu.oop.sw10.car.EngineState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


class CarTest {

    private Car car;
    private Logger mockLogger; // Mocked Logger to capture log statements

    @BeforeEach
    void setUp() {
        this.mockLogger = mock(Logger.class);
        this.car = new Car(mockLogger);
    }

    @Test
    void testDefaultCarState() {
        // assert
        assertTrue(this.car.isSwitchedOff());
    }

    @Test
    void testStartCar() {
        // Act
        this.car.switchOn();

        // Assert states
        assertTrue(this.car.isSwitchedOn());
        // Assert logs
        verify(mockLogger).info("Engine has new value: {}, old value was: {}", EngineState.ON, EngineState.OFF);
        verify(mockLogger).info("{} light has new value: {}, old value was: {}", "Front", 1500, 0);
        verify(mockLogger).info("{} light has new value: {}, old value was: {}", "Back", 1500, 0);
    }

    @Test
    void testStopCar() {
        // Arrange
        car.startCar();
        // check if car is actually running
        assertTrue(this.car.isSwitchedOn());

        // Act
        car.stopCar();

        // Assert states
        assertTrue(this.car.isSwitchedOff());
        // Assert logs
        verify(mockLogger).info("Engine has new value: {}, old value was: {}", EngineState.OFF, EngineState.ON);
        verify(mockLogger).info("{} light has new value: {}, old value was: {}", "Front", 0, 1500);
        verify(mockLogger).info("{} light has new value: {}, old value was: {}", "Back", 0, 1500);
    }
}