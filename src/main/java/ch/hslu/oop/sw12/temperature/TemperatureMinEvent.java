package ch.hslu.oop.sw12.temperature;

import java.io.Serial;
import java.util.EventObject;
import java.util.Objects;

/**
 * The {@code TemperatureMinEvent} class represents an event indicating that a new minimum
 * temperature has been reached. This event carries information about the source of the event,
 * the old minimum temperature, and the new minimum temperature.
 */
public class TemperatureMinEvent extends EventObject implements TemperatureEventInterface {

    @Serial
    private static final long serialVersionUID = 1L;

    // Event type indicating a minimum temperature event.
    private static final EventType eventType = EventType.MIN;

    // The new temperature value that triggered the event.
    private final Temperature newValue;

    // The previous minimum temperature value.
    private final Temperature oldValue;

    /**
     * Constructs a {@code TemperatureMinEvent} with the specified source, old temperature,
     * and new temperature values.
     *
     * @param source   the source of the event (cannot be null)
     * @param oldValue the previous minimum temperature (can be null)
     * @param newValue the new minimum temperature (cannot be null)
     * @throws IllegalArgumentException if the source or newValue is null
     */
    public TemperatureMinEvent(Object source, Temperature oldValue, Temperature newValue) {
        super(source);
        if (newValue == null) {
            throw new IllegalArgumentException("newValue cannot be null.");
        }
        this.newValue = newValue;
        this.oldValue = oldValue;
    }

    /**
     * Gets the new minimum temperature value.
     *
     * @return the new minimum temperature
     */
    public Temperature getNewValue() {
        return newValue;
    }

    /**
     * Gets the previous minimum temperature value.
     *
     * @return the previous minimum temperature, or {@code null} if there was no previous value
     */
    public Temperature getOldValue() {
        return oldValue;
    }

    /**
     * Gets the type of this event, which is always {@code EventType.MIN}.
     *
     * @return the type of the event
     */
    public EventType getEventType() {
        return eventType;
    }

    /**
     * Returns a string representation of the {@code TemperatureMinEvent} instance.
     *
     * @return a string describing the event, including old and new values and the source
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "[source=" + getSource() +
                "; oldValue=" + oldValue +
                "; newValue=" + newValue + "]";
    }

    /**
     * Checks if this {@code TemperatureMinEvent} instance is equal to another object.
     *
     * @param object the object to compare with
     * @return {@code true} if the objects are equal, {@code false} otherwise
     */
    @Override
    public final boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof TemperatureMinEvent)) {
            return false;
        }
        final TemperatureMinEvent other = (TemperatureMinEvent) object;
        return Objects.equals(this.getSource(), other.getSource()) &&
                Objects.equals(this.oldValue, other.oldValue) &&
                Objects.equals(this.newValue, other.newValue);
    }

    /**
     * Computes the hash code for the {@code TemperatureMinEvent} instance.
     *
     * @return the hash code
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getSource(), oldValue, newValue);
    }
}
