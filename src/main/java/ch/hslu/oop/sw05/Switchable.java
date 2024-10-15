package ch.hslu.oop.sw05;

/**
 * The {@code Switchable} interface represents an object that can be switched on and off.
 * It provides methods to control the on/off state and check the current state.
 */
public interface Switchable {

    /**
     * Switches the object on.
     */
    void switchOn();

    /**
     * Switches the object off.
     */
    void switchOff();

    /**
     * Checks if the object is currently switched on.
     *
     * @return {@code true} if the object is switched on, {@code false} otherwise
     */
    boolean isSwitchedOn();

    /**
     * Checks if the object is currently switched off.
     *
     * @return {@code true} if the object is switched off, {@code false} otherwise
     */
    boolean isSwitchedOff();
}
