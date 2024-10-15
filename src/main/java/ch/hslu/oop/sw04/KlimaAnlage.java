package ch.hslu.oop.sw04;

public class KlimaAnlage implements Switchable {

    private boolean acOn = false;
    private int acLevel = 0;
    final private int MAX_LEVEL = 5;

    @Override
    public void switchOn() {
        this.acOn = true;
        this.acLevel = MAX_LEVEL;
    }

    @Override
    public void switchOff() {
        this.acOn = false;
        this.acLevel = 0;
    }

    @Override
    public boolean isSwitchedOn() {
        return this.acOn;
    }

    @Override
    public boolean isSwitchedOff() {
        return !this.acOn;
    }
}
