package ch.hslu.oop.sw11.csv;


import java.util.*;

/**
 * The {@code TemperatureCurve} class maintains a collection of {@code Temperature} objects
 * and provides functionality for adding, removing, and retrieving temperature-related statistics
 * such as maximum, minimum, and average temperatures. It also supports event listeners for
 * temperature changes.
 */
public class TemperatureCurve implements TemperatureCurveInterface {

    // A collection to store temperature instances.
    private final Collection<MeasuringPoint> measuringPoints = new ArrayList<>();

    // A list of listeners for temperature change events.
    private final List<TemperatureChangeListener> changeListeners = new ArrayList<>();

    /**
     * Adds a new temperature to the collection and notifies listeners if it changes
     * the maximum or minimum temperature.
     *
     * @param measuringPoint the temperature to add
     */
    public void addMeasuringPoint(final MeasuringPoint measuringPoint) {
        this.checkForNewTemperatureLimit(measuringPoint);
        this.measuringPoints.add(measuringPoint);
    }

    /**
     * Clears all temperatures from the collection.
     */
    public void clear() {
        this.measuringPoints.clear();
    }

    /**
     * Returns the total number of temperatures in the collection.
     *
     * @return the count of temperatures
     */
    public int getCount() {
        return this.getMeassuringPointList().size();
    }

    /**
     * Returns the maximum temperature in the collection.
     *
     * @return the maximum temperature, or {@code null} if the collection is empty
     */
    public MeasuringPoint getMaxTemperature() {
        if (this.getCount() == 0) return null;
        return Collections.max(this.measuringPoints);
    }

    /**
     * Returns the minimum temperature in the collection.
     *
     * @return the minimum temperature, or {@code null} if the collection is empty
     */
    public MeasuringPoint getMinTemperature() {
        if (this.getCount() == 0) return null;
        return Collections.min(this.measuringPoints);
    }

    /**
     * Calculates the average temperature in Celsius from the collection.
     *
     * @return a {@code Temperature} object representing the average temperature,
     * or {@code null} if the collection is empty
     */
    public MeasuringPoint getAverageCelciusTemperature() {
        if (this.getCount() == 0) return null;
        double temperaturesSum = 0.0;
        for (MeasuringPoint meassuringPoint : this.measuringPoints) {
            temperaturesSum += meassuringPoint.getTemperature().getTemperatureCelcius();
        }
        return new MeasuringPoint(Temperature.createFromCelsius(temperaturesSum / this.getCount()), null);
    }

    /**
     * Returns an unmodifiable view of the temperature collection.
     *
     * @return the collection of temperatures
     */
    public Collection<MeasuringPoint> getMeassuringPointList() {
        return this.measuringPoints;
    }

    /**
     * Adds a listener to be notified of temperature changes.
     *
     * @param listener the listener to add
     */
    public void addPropertyChangeListener(final TemperatureChangeListener listener) {
        if (listener != null) {
            this.changeListeners.add(listener);
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
     * @param newMeasuringPoint the new temperature to check
     */
    private void checkForNewTemperatureLimit(MeasuringPoint newMeasuringPoint) {
        MeasuringPoint maxTemperature = this.getMaxTemperature();
        MeasuringPoint minTemperature = this.getMinTemperature();
        if (maxTemperature == null || maxTemperature.getTemperature().getTemperatureCelcius() < newMeasuringPoint.getTemperature().getTemperatureCelcius()) {
            TemperatureMaxEvent event = new TemperatureMaxEvent(this, maxTemperature, newMeasuringPoint);
            this.firePropertyChangeEvent(event);
        }
        if (minTemperature == null || minTemperature.getTemperature().getTemperatureCelcius() > newMeasuringPoint.getTemperature().getTemperatureCelcius()) {
            TemperatureMinEvent event = new TemperatureMinEvent(this, minTemperature, newMeasuringPoint);
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
        return "TemperatureCurve{" + "measuringPoints=" + measuringPoints + ", changeListeners=" + changeListeners + '}';
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
        return Objects.equals(this.measuringPoints, other.measuringPoints) && Objects.equals(this.changeListeners, other.changeListeners);
    }

    /**
     * Computes the hash code for the {@code TemperatureCurve} instance.
     *
     * @return the hash code
     */
    @Override
    public final int hashCode() {
        return Objects.hash(measuringPoints, changeListeners);
    }
}
