package ch.hslu.oop.sw06;

public abstract class ChemicalElement {
    protected String name;

    public ChemicalElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getStateOfMatter(double temperature);

    protected String evaluateState(double temperature, double freezingPoint, double boilingPoint) {
        if (temperature <= freezingPoint) {
            return "Solid";
        } else if (temperature < boilingPoint) {
            return "Liquid";
        } else {
            return "Gas";
        }
    }

    // Override the toString() method
    @Override
    public String toString() {
        return this.name;
    }
}
