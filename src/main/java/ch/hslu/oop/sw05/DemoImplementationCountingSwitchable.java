package ch.hslu.oop.sw05;

public class DemoImplementationCountingSwitchable implements CountingSwitchable {

    private long counter = 0;
    private boolean isSwitched = false;

    @Override
    public long getSwitchCount() {
        return this.counter;
    }

    @Override
    public void switchOn() {
        this.isSwitched = true;
        this.counter += 1;
    }

    @Override
    public void switchOff() {
        this.isSwitched = false;
        this.counter += 1;
    }

    @Override
    public boolean isSwitchedOn() {
        return this.isSwitched;
    }

    @Override
    public boolean isSwitchedOff() {
        return !this.isSwitched;
    }
}
