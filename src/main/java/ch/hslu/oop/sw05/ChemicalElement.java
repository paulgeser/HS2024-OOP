package ch.hslu.oop.sw05;

public abstract class ChemicalElement {
    protected String name;

    public ChemicalElement(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getStateOfMatter(double temperature);

    protected String evaluateState(final double temperature, final double freezingPoint, final double boilingPoint) {
        if (temperature <= freezingPoint) {
            return "Solid";
        } else if (temperature < boilingPoint) {
            return "Liquid";
        } else {
            return "Gas";
        }
    }
}
