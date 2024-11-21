package ch.hslu.oop.sw10.car;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents an engine that can be switched on or off and has a state and RPM (Revolutions Per Minute).
 * The engine fires property change events when its state changes.
 */
public class Engine implements Switchable {

    // Current state of the engine (ON or OFF)
    private EngineState state = EngineState.OFF;

    // Current RPM of the engine
    private int rpm = 0;

    // Maximum allowable RPM for the engine
    private final int MAX_RPM = 3000;

    // List of listeners for property change events
    private final List<PropertyChangeListener> changeListeners = new ArrayList<>();

    /**
     * Switches the engine on.
     * Changes the engine state to ON and sets RPM to the maximum value.
     * Fires a property change event to notify listeners.
     */
    @Override
    public void switchOn() {
        if (this.state == EngineState.OFF) {
            this.state = EngineState.ON;
            this.rpm = MAX_RPM;
            final PropertyChangeEvent engineEvent = new PropertyChangeEvent(this, "state", EngineState.OFF, EngineState.ON);
            this.firePropertyChangeEvent(engineEvent);
        }
    }

    /**
     * Switches the engine off.
     * Changes the engine state to OFF and sets RPM to zero.
     * Fires a property change event to notify listeners.
     */
    @Override
    public void switchOff() {
        if (this.state == EngineState.ON) {
            this.state = EngineState.OFF;
            this.rpm = 0;
            final PropertyChangeEvent engineEvent = new PropertyChangeEvent(this, "state", EngineState.ON, EngineState.OFF);
            this.firePropertyChangeEvent(engineEvent);
        }
    }

    /**
     * Checks if the engine is currently switched on.
     *
     * @return {@code true} if the engine is ON, {@code false} otherwise.
     */
    @Override
    public boolean isSwitchedOn() {
        return this.state == EngineState.ON;
    }

    /**
     * Checks if the engine is currently switched off.
     *
     * @return {@code true} if the engine is OFF, {@code false} otherwise.
     */
    @Override
    public boolean isSwitchedOff() {
        return this.state == EngineState.OFF;
    }

    /**
     * Adds a property change listener to be notified of state changes.
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
     * Returns a string representation of the engine, including its state and RPM.
     *
     * @return a string representation of the engine
     */
    @Override
    public String toString() {
        return "Engine{" + "state=" + this.state + ", " + "rpm=" + this.rpm + '}';
    }

    /**
     * Checks if this engine is equal to another object.
     * Two engines are considered equal if they have the same state and RPM.
     *
     * @param o the object to compare
     * @return {@code true} if the engines are equal, {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return rpm == engine.rpm && state == engine.state;
    }

    /**
     * Generates a hash code for the engine based on its state and RPM.
     *
     * @return the hash code for the engine
     */
    @Override
    public int hashCode() {
        return Objects.hash(state, rpm);
    }
}
