package ch.hslu.oop.sw05;

public class Oxygen extends ChemicalElement {

    private final double freezingPoint = -218.79;
    private final double boilingPoint = -183;

    public Oxygen() {
        super("Oxygen");
    }

    @Override
    public String getStateOfMatter(double temperature) {
        return this.evaluateState(temperature, this.freezingPoint, this.boilingPoint);
    }
}
