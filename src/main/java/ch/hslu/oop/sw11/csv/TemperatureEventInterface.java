package ch.hslu.oop.sw11.csv;

/**
 * The {@code TemperatureEventInterface} defines the contract for temperature-related events.
 * Implementing classes represent events that carry information about temperature changes,
 * such as new minimum or maximum temperatures.
 */
public interface TemperatureEventInterface {

    /**
     * Gets the type of the temperature event, such as a minimum or maximum event.
     *
     * @return the event type as an {@code EventType} enumeration
     */
    EventType getEventType();

    /**
     * Gets the new temperature value associated with the event.
     *
     * @return the new temperature value as a {@code Temperature} object
     */
    MeasuringPoint getNewValue();

    /**
     * Gets the old temperature value associated with the event, if applicable.
     *
     * @return the old temperature value as a {@code Temperature} object, or {@code null}
     * if no previous value is available
     */
    MeasuringPoint getOldValue();
}
