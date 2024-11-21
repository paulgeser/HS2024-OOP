package ch.hslu.oop.sw10.temperature;

import java.io.Serial;
import java.util.EventObject;
import java.util.Objects;

/**
 * The {@code TemperatureMaxEvent} class represents an event indicating that a new maximum
 * temperature has been reached. This event carries information about the source of the event,
 * the old maximum temperature, and the new maximum temperature.
 */
public class TemperatureMaxEvent extends EventObject implements TemperatureEventInterface {

    @Serial
    private static final long serialVersionUID = 1L;

    // Event type indicating a maximum temperature event.
    private static final EventType eventType = EventType.MAX;

    // The new temperature value that triggered the event.
    private final Temperature newValue;

    // The previous maximum temperature value.
    private final Temperature oldValue;

    /**
     * Constructs a {@code TemperatureMaxEvent} with the specified source, old temperature,
     * and new temperature values.
     *
     * @param source    the source of the event (cannot be null)
     * @param oldValue  the previous maximum temperature (can be null)
     * @param newValue  the new maximum temperature (cannot be null)
     * @throws IllegalArgumentException if the source or newValue is null
     */
    public TemperatureMaxEvent(Object source, Temperature oldValue, Temperature newValue) {
        super(source);
        if (newValue == null) {
            throw new IllegalArgumentException("newValue cannot be null.");
        }
        this.newValue = newValue;
        this.oldValue = oldValue;
    }

    /**
     * Gets the new maximum temperature value.
     *
     * @return the new maximum temperature
     */
    public Temperature getNewValue() {
        return newValue;
    }

    /**
     * Gets the previous maximum temperature value.
     *
     * @return the previous maximum temperature, or {@code null} if there was no previous value
     */
    public Temperature getOldValue() {
        return oldValue;
    }

    /**
     * Gets the type of this event, which is always {@code EventType.MAX}.
     *
     * @return the type of the event
     */
    public EventType getEventType() {
        return eventType;
    }

    /**
     * Returns a string representation of the {@code TemperatureMaxEvent} instance.
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
     * Checks if this {@code TemperatureMaxEvent} instance is equal to another object.
     *
     * @param object the object to compare with
     * @return {@code true} if the objects are equal, {@code false} otherwise
     */
    @Override
    public final boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof TemperatureMaxEvent)) {
            return false;
        }
        final TemperatureMaxEvent other = (TemperatureMaxEvent) object;
        return Objects.equals(this.getSource(), other.getSource()) &&
                Objects.equals(this.oldValue, other.oldValue) &&
                Objects.equals(this.newValue, other.newValue);
    }

    /**
     * Computes the hash code for the {@code TemperatureMaxEvent} instance.
     *
     * @return the hash code
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getSource(), oldValue, newValue);
    }
}
