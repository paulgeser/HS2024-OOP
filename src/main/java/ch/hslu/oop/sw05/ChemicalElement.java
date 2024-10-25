package ch.hslu.oop.sw05;

public abstract class ChemicalElement {
    private final String name;
    private final double freezingPoint;
    private final double boilingPoint;

    public ChemicalElement(final String name, double freezingPoint, double boilingPoint) {
        this.name = name;
        this.freezingPoint = freezingPoint;
        this.boilingPoint = boilingPoint;
    }

    public String getName() {
        return this.name;
    }

    public String evaluateState(final double temperature) {
        if (temperature <= this.freezingPoint) {
            return "Solid";
        } else if (temperature < this.boilingPoint) {
            return "Liquid";
        } else {
            return "Gas";
        }
    }
}
