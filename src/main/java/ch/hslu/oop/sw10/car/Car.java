package ch.hslu.oop.sw10.car;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

/**
 * The {@code Car} class represents a car with an engine, front light, and back light.
 * It implements the {@code Switchable} interface, allowing the car and its components
 * to be turned on or off as a whole.
 */
public class Car implements Switchable {

    // Logger instance for logging messages
    private final Logger logger;

    // The engine of the car
    private final Engine engine;

    // The front light of the car
    private final Light frontLight;

    // The back light of the car
    private final Light backLight;

    /**
     * Constructs a new {@code Car} instance.
     * Initializes the engine, front light, and back light, and adds listeners to their property change events.
     *
     * @param logger the logger instance to be used for logging events
     */
    public Car(final Logger logger) {
        this.logger = logger;
        this.engine = new Engine();
        this.frontLight = new Light();
        this.backLight = new Light();

        // Attach listeners to handle events for the engine and lights
        this.engine.addPropertyChangeListener(this::handleEngineEvent);
        this.frontLight.addPropertyChangeListener(event -> handleLightEvent(event, "Front"));
        this.backLight.addPropertyChangeListener(event -> handleLightEvent(event, "Back"));
    }

    /**
     * Starts the car by switching on the engine.
     */
    public void startCar() {
        this.engine.switchOn();
    }

    /**
     * Stops the car by switching off the engine.
     */
    public void stopCar() {
        this.engine.switchOff();
    }

    /**
     * Gets the engine of the car.
     *
     * @return the car's engine
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * Gets the front light of the car.
     *
     * @return the car's front light
     */
    public Light getFrontLight() {
        return frontLight;
    }

    /**
     * Gets the back light of the car.
     *
     * @return the car's back light
     */
    public Light getBackLight() {
        return backLight;
    }

    @Override
    public void switchOn() {
        // Switch on all components of the car
        this.engine.switchOn();
        this.frontLight.switchOn();
        this.backLight.switchOn();
    }

    @Override
    public void switchOff() {
        // Switch off all components of the car
        this.engine.switchOff();
        this.frontLight.switchOff();
        this.backLight.switchOff();
    }

    @Override
    public boolean isSwitchedOn() {
        // Return true if any component of the car is switched on
        return this.engine.isSwitchedOn() || this.frontLight.isSwitchedOn() || this.backLight.isSwitchedOn();
    }

    @Override
    public boolean isSwitchedOff() {
        // Return true if all components of the car are switched off
        return this.engine.isSwitchedOff() && this.frontLight.isSwitchedOff() && this.backLight.isSwitchedOff();
    }

    @Override
    public String toString() {
        // Returns a string representation of the car and its components
        return "Car{" +
                "engine=" + engine.toString() +
                ", frontLight=" + frontLight.toString() +
                ", backLight=" + backLight.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        // Checks for equality based on the engine, front light, and back light states
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(engine, car.engine) &&
                Objects.equals(frontLight, car.frontLight) &&
                Objects.equals(backLight, car.backLight);
    }

    @Override
    public int hashCode() {
        // Generates a hash code based on the engine, front light, and back light states
        return Objects.hash(engine, frontLight, backLight);
    }

    /**
     * Handles engine-related property change events.
     * Logs the event and synchronizes the lights with the engine state.
     *
     * @param event the engine property change event
     */
    private void handleEngineEvent(PropertyChangeEvent event) {
        getLogger().info("Engine has new value: {}, old value was: {}", event.getNewValue(), event.getOldValue());
        if (event.getNewValue() == EngineState.ON) {
            this.frontLight.switchOn();
            this.backLight.switchOn();
        } else if (event.getNewValue() == EngineState.OFF) {
            this.frontLight.switchOff();
            this.backLight.switchOff();
        }
    }

    /**
     * Handles light-related property change events.
     * Logs the event with details about the light type.
     *
     * @param event     the light property change event
     * @param lightType the type of light ("Front" or "Back")
     */
    private void handleLightEvent(PropertyChangeEvent event, String lightType) {
        getLogger().info("{} light has new value: {}, old value was: {}", lightType, event.getNewValue(), event.getOldValue());
    }

    /**
     * Returns the logger instance for this car.
     *
     * @return the logger instance
     */
    protected Logger getLogger() {
        return this.logger;
    }
}
