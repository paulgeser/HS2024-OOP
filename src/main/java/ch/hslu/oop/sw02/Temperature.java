package ch.hslu.oop.sw02;

public class Temperature {

    private double temperatureCelcius = 20.0;

    public Temperature(double temperaturCelcius) {
        this.temperatureCelcius = temperaturCelcius;
    }

    public double getTemperatureCelcius() {
        return temperatureCelcius;
    }

    public void setTemperatureCelcius(double temperatureCelcius) {
        this.temperatureCelcius = temperatureCelcius;
    }

    public double getTemperaturKelvin() {
        return temperatureCelcius + 273.15;
    }

    public double getTemperaturFahrenheit() {
        return temperatureCelcius * 1.8 + 32;
    }

    public void increaseTemperature(double temperatureChange) {
        this.temperatureCelcius = this.temperatureCelcius + temperatureChange;
    }

    public void decreaseTemperature(double temperatureChange) {
        this.temperatureCelcius = this.temperatureCelcius - temperatureChange;
    }
}
