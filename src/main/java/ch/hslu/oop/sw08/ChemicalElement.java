package ch.hslu.oop.sw08;

import java.util.Objects;

public abstract class ChemicalElement implements Comparable<ChemicalElement> {
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

    public AggregationState evaluateState(final double temperature) {
        if (temperature <= this.freezingPoint) {
            return AggregationState.SOLID;
        } else if (temperature < this.boilingPoint) {
            return AggregationState.LIQUID;
        } else {
            return AggregationState.GAS;
        }
    }

    public double getFreezingPoint() {
        return freezingPoint;
    }

    public double getBoilingPoint() {
        return boilingPoint;
    }

    @Override
    public String toString() {
        return "Chemical Element name=" + name + ", freezingPoint=" + freezingPoint + ", boilingPoint=" + boilingPoint;
    }

    @Override
    public final boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        return (object instanceof ChemicalElement p) && Objects.equals(p.getName(), this.name) && Objects.equals(p.getBoilingPoint(), this.boilingPoint) && Objects.equals(p.getFreezingPoint(), this.freezingPoint);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.name, this.freezingPoint, this.boilingPoint);
    }

    @Override
    public final int compareTo(final ChemicalElement o) {
        return Integer.compare(Double.compare(this.freezingPoint, o.getFreezingPoint()), Double.compare(this.boilingPoint, o.getBoilingPoint()));
    }
}
