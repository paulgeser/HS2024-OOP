package ch.hslu.oop.sw12.temperature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * The {@code Temperature} class represents a temperature value in Celsius and provides
 * methods to convert it to Kelvin and Fahrenheit, modify it, and determine the state
 * of aggregation of elements at the current temperature.
 */
public final class Temperature implements Comparable<Temperature> {

    // The current temperature in Celsius. Default is 20.0°C.
    private double temperatureCelcius = 20.0;

    // The offset for converting between Celsius and Kelvin.
    private static final double KELVIN_OFFSET = 273.15;

    // Logger for logging temperature-related events or errors.
    private static final Logger LOG = LoggerFactory.getLogger(Temperature.class);

    /**
     * Constructs a new {@code Temperature} instance with the specified value in Celsius.
     *
     * @param temperaturCelcius the initial temperature in Celsius
     */
    private Temperature(double temperaturCelcius) {
        this.setTemperatureCelcius(temperaturCelcius);
    }

    /**
     * Factory method to create a {@code Temperature} instance from Celsius.
     *
     * @param celsius the temperature in Celsius
     * @return a new {@code Temperature} instance
     */
    public static Temperature createFromCelsius(final double celsius) {
        return new Temperature(celsius);
    }

    /**
     * Factory method to create a {@code Temperature} instance from Kelvin.
     *
     * @param kelvin the temperature in Kelvin
     * @return a new {@code Temperature} instance
     */
    public static Temperature createFromKelvin(final double kelvin) {
        return new Temperature(kelvin - KELVIN_OFFSET);
    }

    /**
     * Returns the current temperature in Celsius.
     *
     * @return the temperature in Celsius
     */
    public double getTemperatureCelcius() {
        return temperatureCelcius;
    }

    /**
     * Sets the temperature to the specified value in Celsius.
     *
     * @param temperatureCelcius the new temperature in Celsius
     * @throws IllegalArgumentException if the temperature is below absolute zero
     */
    private void setTemperatureCelcius(double temperatureCelcius) {
        if (temperatureCelcius < -KELVIN_OFFSET) {
            LOG.error("Invalid temperature celcius was given: {}!", temperatureCelcius);
            throw new IllegalArgumentException("Invalid temperature input!");
        }
        this.temperatureCelcius = temperatureCelcius;
    }

    /**
     * Returns the current temperature in Kelvin.
     *
     * @return the temperature in Kelvin
     */
    public double getTemperaturKelvin() {
        return this.convertCelsiusToKelvin(this.temperatureCelcius);
    }

    /**
     * Returns the current temperature in Fahrenheit.
     *
     * @return the temperature in Fahrenheit
     */
    public double getTemperaturFahrenheit() {
        return temperatureCelcius * 1.8 + 32;
    }

    /**
     * Increases the current temperature by the specified amount.
     *
     * @param temperatureChange the amount to increase the temperature by, in Celsius
     */
    public void increaseTemperature(double temperatureChange) {
        this.temperatureCelcius = this.temperatureCelcius + temperatureChange;
    }

    /**
     * Decreases the current temperature by the specified amount.
     *
     * @param temperatureChange the amount to decrease the temperature by, in Celsius
     */
    public void decreaseTemperature(double temperatureChange) {
        this.temperatureCelcius = this.temperatureCelcius - temperatureChange;
    }

    /**
     * Determines the state of aggregation of a specified element at the current temperature.
     * Supported elements include nitrogen ("N"), mercury ("Hg"), and lead ("Pb").
     *
     * @param element the symbol of the element ("N", "Hg", "Pb")
     * @return the state of aggregation of the element, either "fest" (solid), "flüssig" (liquid),
     * "gasförmig" (gaseous), or "Element is not known" if the element is unsupported
     */
    public String getStateOfAggregation(String element) {
        return switch (element) {
            case "N" -> this.temperatureCelcius < -210.0 ? "fest" :
                    this.temperatureCelcius < -196.0 ? "flüssig" : "gasförmig";
            case "Hg" -> this.temperatureCelcius < -38.83 ? "fest" :
                    this.temperatureCelcius < 356.73 ? "flüssig" : "gasförmig";
            case "Pb" -> this.temperatureCelcius < 327.5 ? "fest" :
                    this.temperatureCelcius < 1749 ? "flüssig" : "gasförmig";
            default -> "Element is not known";
        };
    }

    /**
     * Determines the state of aggregation of an element based on its melting and boiling points.
     *
     * @param meltingPoint the melting point of the element in Celsius
     * @param boilingPoint the boiling point of the element in Celsius
     * @return the state of aggregation of the element, either "fest" (solid), "flüssig" (liquid),
     * or "gasförmig" (gaseous)
     */
    public String getStateOfAggregation(Double meltingPoint, Double boilingPoint) {
        return this.temperatureCelcius < meltingPoint ? "fest" :
                this.temperatureCelcius < boilingPoint ? "flüssig" : "gasförmig";
    }

    /**
     * Converts a temperature from Kelvin to Celsius.
     *
     * @param kelvin the temperature in Kelvin
     * @return the equivalent temperature in Celsius
     */
    public final double convertKelvinToCelsius(final double kelvin) {
        return kelvin - KELVIN_OFFSET;
    }

    /**
     * Converts a temperature from Celsius to Kelvin.
     *
     * @param celsius the temperature in Celsius
     * @return the equivalent temperature in Kelvin
     */
    public final double convertCelsiusToKelvin(final double celsius) {
        return celsius + KELVIN_OFFSET;
    }

    /**
     * Returns a string representation of the {@code Temperature} instance.
     *
     * @return a string representation in the format "Temperature{temperatureCelcius=value}"
     */
    @Override
    public final String toString() {
        return "Temperature{" + "temperatureCelcius=" + temperatureCelcius + '}';
    }

    /**
     * Checks if two {@code Temperature} instances are equal based on their temperature in Celsius.
     *
     * @param object the object to compare with
     * @return {@code true} if the objects are equal, {@code false} otherwise
     */
    @Override
    public final boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        return (object instanceof Temperature p) &&
                Objects.equals(p.getTemperatureCelcius(), this.temperatureCelcius);
    }

    /**
     * Computes the hash code for the {@code Temperature} instance based on its temperature in Celsius.
     *
     * @return the hash code
     */
    @Override
    public final int hashCode() {
        return Objects.hash(this.temperatureCelcius);
    }

    /**
     * Compares this {@code Temperature} instance with another based on their temperature in Celsius.
     *
     * @param o the other {@code Temperature} instance to compare with
     * @return a negative value if this instance is less than the other, zero if equal,
     * or a positive value if greater
     */
    @Override
    public final int compareTo(final Temperature o) {
        return Double.compare(this.getTemperatureCelcius(), o.getTemperatureCelcius());
    }
}
