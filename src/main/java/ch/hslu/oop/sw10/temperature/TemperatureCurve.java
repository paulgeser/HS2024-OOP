package ch.hslu.oop.sw10.temperature;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * The {@code TemperatureCurve} class maintains a collection of {@code Temperature} objects
 * and provides functionality for adding, removing, and retrieving temperature-related statistics
 * such as maximum, minimum, and average temperatures. It also supports event listeners for
 * temperature changes.
 */
public class TemperatureCurve implements TemperatureCurceInterface {

    // A collection to store temperature instances.
    private final Collection<Temperature> temperatures = new ArrayList<>();

    // A list of listeners for temperature change events.
    private final List<TemperatureChangeListener> changeListeners = new ArrayList<>();

    private Temperature maxTemperature = null;
    private Temperature minTemperature = null;

    /**
     * Adds a new temperature to the collection and notifies listeners if it changes
     * the maximum or minimum temperature.
     *
     * @param temperature the temperature to add
     */
    public void addTemperature(final Temperature temperature) {
        this.temperatures.add(temperature);
        this.checkForNewTemperatureLimit(temperature);
    }

    /**
     * Clears all temperatures from the collection.
     */
    public void clear() {
        this.temperatures.clear();
    }

    /**
     * Returns the total number of temperatures in the collection.
     *
     * @return the count of temperatures
     */
    public int getCount() {
        return this.temperatures.size();
    }

    /**
     * Returns the maximum temperature in the collection.
     *
     * @return the maximum temperature, or {@code null} if the collection is empty
     */
    public Temperature getMaxTemperature() {
        return this.maxTemperature;
    }

    /**
     * Returns the minimum temperature in the collection.
     *
     * @return the minimum temperature, or {@code null} if the collection is empty
     */
    public Temperature getMinTemperature() {
        return this.minTemperature;
    }

    /**
     * Calculates the average temperature in Celsius from the collection.
     *
     * @return a {@code Temperature} object representing the average temperature,
     * or {@code null} if the collection is empty
     */
    public Temperature getAverageCelciusTemperature() {
        if (this.getCount() == 0) return null;
        double temperaturesSum = 0.0;
        for (Temperature temperature : this.temperatures) {
            temperaturesSum += temperature.getTemperatureCelcius();
        }
        return Temperature.createFromCelsius(temperaturesSum / this.getCount());
    }

    /**
     * Returns an unmodifiable view of the temperature collection.
     *
     * @return the collection of temperatures
     */
    public Collection<Temperature> getTemperatureList() {
        return this.temperatures;
    }

    /**
     * Adds a listener to be notified of temperature changes.
     *
     * @param listener the listener to add
     */
    public void addPropertyChangeListener(final TemperatureChangeListener listener) {
        if (listener != null) {
            this.changeListeners.add(listener);
        } else {
            throw new NullPointerException("Given listener is null!");
        }
    }

    /**
     * Removes a listener from receiving temperature change notifications.
     *
     * @param listener the listener to remove
     */
    public void removePropertyChangeListener(final TemperatureChangeListener listener) {
        if (listener != null) {
            this.changeListeners.remove(listener);
        } else {
            throw new NullPointerException("Given listener is null!");
        }
    }

    /**
     * Notifies all registered listeners about a temperature change event.
     *
     * @param temperatureEvent the event to notify listeners about
     */
    private void firePropertyChangeEvent(final TemperatureEventInterface temperatureEvent) {
        for (final TemperatureChangeListener listener : this.changeListeners) {
            listener.temperatureChange(temperatureEvent);
        }
    }

    /**
     * Checks if the new temperature changes the maximum or minimum temperature
     * and notifies listeners accordingly.
     *
     * @param newTemperature the new temperature to check
     */
    private void checkForNewTemperatureLimit(Temperature newTemperature) {
        if (this.maxTemperature == null || newTemperature.getTemperatureCelcius() > this.maxTemperature.getTemperatureCelcius()) {
            Temperature previousMaxTemperature = this.maxTemperature;
            this.maxTemperature = newTemperature;
            TemperatureMaxEvent event = new TemperatureMaxEvent(this, previousMaxTemperature, newTemperature);
            this.firePropertyChangeEvent(event);
        }
        if (this.minTemperature == null || newTemperature.getTemperatureCelcius() < this.minTemperature.getTemperatureCelcius()) {
            Temperature previousMinTemperature = this.minTemperature;
            this.minTemperature = newTemperature;
            TemperatureMinEvent event = new TemperatureMinEvent(this, previousMinTemperature, newTemperature);
            this.firePropertyChangeEvent(event);
        }
    }

    /**
     * Returns a string representation of the {@code TemperatureCurve} instance.
     *
     * @return a string representation including the count of temperatures
     */
    @Override
    public final String toString() {
        return "TemperatureCurve{" +
                "temperatures=" + temperatures +
                ", changeListeners=" + changeListeners +
                ", maxTemperature=" + maxTemperature +
                ", minTemperature=" + minTemperature +
                '}';
    }

    /**
     * Checks if this {@code TemperatureCurve} instance is equal to another object.
     *
     * @param object the object to compare with
     * @return {@code true} if the objects are equal, {@code false} otherwise
     */
    @Override
    public final boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof TemperatureCurve)) {
            return false;
        }
        final TemperatureCurve other = (TemperatureCurve) object;
        return Objects.equals(this.temperatures, other.temperatures) &&
                Objects.equals(this.changeListeners, other.changeListeners);
    }

    /**
     * Computes the hash code for the {@code TemperatureCurve} instance.
     *
     * @return the hash code
     */
    @Override
    public final int hashCode() {
        return Objects.hash(temperatures, changeListeners);
    }
}
