package ch.hslu.oop.sw05;

public class Nitrogen extends ChemicalElement {

    private final double freezingPoint = -210.0;
    private final double boilingPoint = -196.0;

    public Nitrogen() {
        super("Nitrogen");
    }

    @Override
    public String getStateOfMatter(double temperature) {
        return this.evaluateState(temperature, this.freezingPoint, this.boilingPoint);
    }
}
