package ch.hslu.oop.sw03;

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

    public String getStateOfAggregation(Double meltingPoint, Double boilingPoint) {
        return this.temperatureCelcius < meltingPoint ? "fest" : this.temperatureCelcius < boilingPoint ? "flüssig" : "gasförmig";
    }
}
