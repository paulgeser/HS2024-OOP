package ch.hslu.oop.sw06;

public class Mercury extends ChemicalElement {

    private final double freezingPoint = -38.83;
    private final double boilingPoint = 356.73;

    public Mercury() {
        super("Mercury");
    }

    @Override
    public String getStateOfMatter(double temperature) {
        return this.evaluateState(temperature, this.freezingPoint, this.boilingPoint);
    }

    // Override the toString() method
    @Override
    public String toString() {
        return "GIFTIG!!!";
    }
}
