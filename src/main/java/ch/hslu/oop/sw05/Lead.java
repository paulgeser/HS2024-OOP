package ch.hslu.oop.sw05;

public class Lead extends ChemicalElement {

    private final double freezingPoint = 327.5;
    private final double boilingPoint = 1749;

    public Lead() {
        super("Lead");
    }

    @Override
    public String getStateOfMatter(double temperature) {
        return this.evaluateState(temperature, this.freezingPoint, this.boilingPoint);
    }
}
