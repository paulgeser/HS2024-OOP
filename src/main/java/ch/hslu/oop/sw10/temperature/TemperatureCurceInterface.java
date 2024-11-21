package ch.hslu.oop.sw10.temperature;

import java.util.Collection;

/**
 * The {@code TemperatureCurceInterface} defines the contract for managing a collection
 * of temperature measurements. Implementing classes provide functionalities to add,
 * remove, and retrieve statistical data about temperatures.
 */
public interface TemperatureCurceInterface {

    /**
     * Adds a new temperature to the collection.
     *
     * @param t the {@code Temperature} object to add (cannot be null)
     */
    void addTemperature(final Temperature t);

    /**
     * Clears all temperatures from the collection.
     */
    void clear();

    /**
     * Gets the total count of temperatures in the collection.
     *
     * @return the number of temperature entries
     */
    int getCount();

    /**
     * Retrieves the maximum temperature from the collection.
     *
     * @return the maximum {@code Temperature}, or {@code null} if the collection is empty
     */
    Temperature getMaxTemperature();

    /**
     * Retrieves the minimum temperature from the collection.
     *
     * @return the minimum {@code Temperature}, or {@code null} if the collection is empty
     */
    Temperature getMinTemperature();

    /**
     * Calculates the average temperature of the collection in Celsius.
     *
     * @return a {@code Temperature} object representing the average temperature in Celsius,
     * or {@code null} if the collection is empty
     */
    Temperature getAverageCelciusTemperature();

    /**
     * Retrieves all temperatures in the collection as a read-only list.
     *
     * @return a {@code Collection} of {@code Temperature} objects representing the temperatures
     */
    Collection<Temperature> getTemperatureList();
}
