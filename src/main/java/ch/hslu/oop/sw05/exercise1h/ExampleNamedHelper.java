package ch.hslu.oop.sw05.exercise1h;

public class ExampleNamedHelper {
    // Helper object provides the functions setName and getName
    private final NamedHelper namedHelper = new NamedHelper();

    public void setName(final String name) {
        namedHelper.setName(name);
    }

    public String getName() {
        return namedHelper.getName();
    }
}
