package ch.hslu.oop.sw12.temperature;

/**
 * The {@code TemperatureChangeListener} interface defines the contract for classes
 * that wish to be notified of changes in temperature events. Implementing classes
 * handle temperature change events triggered by a source.
 */
public interface TemperatureChangeListener {

    /**
     * Handles a temperature change event.
     *
     * @param evt the {@code TemperatureEventInterface} object containing information about
     *            the temperature change event (cannot be null)
     */
    void temperatureChange(TemperatureEventInterface evt);
}
