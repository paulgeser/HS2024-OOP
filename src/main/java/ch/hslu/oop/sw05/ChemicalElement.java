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
        return name;
    }

    protected String evaluateState(final double temperature) {
        if (temperature <= freezingPoint) {
            return "Solid";
        } else if (temperature < boilingPoint) {
            return "Liquid";
        } else {
            return "Gas";
        }
    }
}
