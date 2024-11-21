package ch.hslu.oop.sw10.car;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a Light that can be switched on or off, emitting a certain amount of light (measured in lumens).
 * The Light fires property change events when its state or lumens change.
 */
public class Light implements Switchable {

    // Current lumen output of the light
    private int lumen = 0;

    // Maximum possible lumen output
    private static final int MAX_LUMEN = 1500;

    // List of listeners for property change events
    private final List<PropertyChangeListener> changeListeners = new ArrayList<>();

    /**
     * Gets the current lumen output of the light.
     *
     * @return the current lumen output
     */
    public int getLumen() {
        return this.lumen;
    }

    /**
     * Switches the light on.
     * Sets the lumen to the maximum value and fires a property change event.
     */
    @Override
    public void switchOn() {
        if (this.lumen == 0) {
            this.lumen = MAX_LUMEN;
            final PropertyChangeEvent event = new PropertyChangeEvent(this, "lumen", 0, this.lumen);
            this.firePropertyChangeEvent(event);
        }
    }

    /**
     * Switches the light off.
     * Sets the lumen to zero and fires a property change event.
     */
    @Override
    public void switchOff() {
        if (this.lumen != 0) {
            this.lumen = 0;
            final PropertyChangeEvent event = new PropertyChangeEvent(this, "lumen", MAX_LUMEN, 0);
            this.firePropertyChangeEvent(event);
        }
    }

    /**
     * Checks if the light is currently switched on.
     *
     * @return {@code true} if the light is emitting lumens, {@code false} otherwise
     */
    @Override
    public boolean isSwitchedOn() {
        return this.lumen > 0;
    }

    /**
     * Checks if the light is currently switched off.
     *
     * @return {@code true} if the light is not emitting lumens, {@code false} otherwise
     */
    @Override
    public boolean isSwitchedOff() {
        return this.lumen == 0;
    }

    /**
     * Adds a property change listener to be notified of changes to the light's state or lumen output.
     *
     * @param listener the listener to add
     */
    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        if (listener != null) {
            this.changeListeners.add(listener);
        }
    }

    /**
     * Removes a property change listener.
     *
     * @param listener the listener to remove
     */
    public void removePropertyChangeListener(final PropertyChangeListener listener) {
        if (listener != null) {
            this.changeListeners.remove(listener);
        }
    }

    /**
     * Fires a property change event to all registered listeners.
     *
     * @param pcEvent the property change event to fire
     */
    private void firePropertyChangeEvent(final PropertyChangeEvent pcEvent) {
        for (final PropertyChangeListener listener : this.changeListeners) {
            listener.propertyChange(pcEvent);
        }
    }

    /**
     * Returns a string representation of the Light, including its current lumen output.
     *
     * @return a string representation of the Light
     */
    @Override
    public String toString() {
        return "Light{" + "lumen=" + lumen + '}';
    }

    /**
     * Checks if this Light is equal to another object.
     * Two Lights are considered equal if they have the same lumen output.
     *
     * @param o the object to compare
     * @return {@code true} if the Lights are equal, {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Light light = (Light) o;
        return lumen == light.lumen;
    }

    /**
     * Generates a hash code for the Light based on its lumen output.
     *
     * @return the hash code for the Light
     */
    @Override
    public int hashCode() {
        return Objects.hash(lumen);
    }
}
