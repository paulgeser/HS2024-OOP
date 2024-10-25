package ch.hslu.oop.sw05;

public class Mercury extends ChemicalElement {

    private final double freezingPoint = -38.83;
    private final double boilingPoint = 356.73;

    public Mercury() {
        super("Mercury");
    }

    @Override
    public String getStateOfMatter(final double temperature) {
        return this.evaluateState(temperature, this.freezingPoint, this.boilingPoint);
    }
}
