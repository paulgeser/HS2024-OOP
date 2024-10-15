package ch.hslu.oop.sw05.exercise1h;

public abstract class NamedAbstract implements INamed {
    private String name;

    @Override
    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}