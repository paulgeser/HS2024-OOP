package ch.hslu.oop.sw08;

import java.util.Objects;

/**
 * The {@code Temperature} class represents a temperature value in Celsius and provides
 * methods to convert it to Kelvin and Fahrenheit, modify it, and determine the state
 * of aggregation of elements at the current temperature.
 */
public final class Temperature implements Comparable<Temperature> {

    private double temperatureCelcius = 20.0;
    private static final double KELVIN_OFFSET = 273.15;

    /**
     * Constructs a new {@code Temperature} instance with the specified value in Celsius.
     *
     * @param temperaturCelcius the initial temperature in Celsius
     */
    public Temperature(double temperaturCelcius) {
        this.temperatureCelcius = temperaturCelcius;
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
     */
    public void setTemperatureCelcius(double temperatureCelcius) {
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
            case "N" ->
                    this.temperatureCelcius < -210.0 ? "fest" : this.temperatureCelcius < -196.0 ? "flüssig" : "gasförmig";
            case "Hg" ->
                    this.temperatureCelcius < -38.83 ? "fest" : this.temperatureCelcius < 356.73 ? "flüssig" : "gasförmig";
            case "Pb" ->
                    this.temperatureCelcius < 327.5 ? "fest" : this.temperatureCelcius < 1749 ? "flüssig" : "gasförmig";
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
        return this.temperatureCelcius < meltingPoint ? "fest" : this.temperatureCelcius < boilingPoint ? "flüssig" : "gasförmig";
    }


    @Override
    public final String toString() {
        return "Temperature{" + "temperatureCelcius=" + temperatureCelcius + '}';
    }

    @Override
    public final boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        return (object instanceof Temperature p) && Objects.equals(p.getTemperatureCelcius(), this.temperatureCelcius);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.temperatureCelcius);
    }

    @Override
    public final int compareTo(final Temperature o) {
        return Double.compare(this.getTemperatureCelcius(), o.getTemperatureCelcius());
    }

    public final double convertKelvinToCelsius(final double kelvin) {
        return kelvin - this.KELVIN_OFFSET;
    }

    public final double convertCelsiusToKelvin(final double celsius) {
        return celsius + this.KELVIN_OFFSET;
    }
}
