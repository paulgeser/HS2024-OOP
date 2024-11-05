package ch.hslu.oop.sw08;

public enum AggregationState {
    SOLID("fest"), LIQUID("flüssig"), GAS("gasförmig");

    private String description;

    AggregationState(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
