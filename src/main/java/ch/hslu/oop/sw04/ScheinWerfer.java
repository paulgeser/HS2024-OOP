package ch.hslu.oop.sw04;

public class ScheinWerfer implements Switchable {

    private boolean lightOn = false;
    private int lightStrength = 0;
    final private int MAX_LUMEN = 2000;

    @Override
    public void switchOn() {
        this.lightOn = true;
        this.lightStrength = MAX_LUMEN;
    }

    @Override
    public void switchOff() {
        this.lightOn = false;
        this.lightStrength = 0;
    }

    @Override
    public boolean isSwitchedOn() {
        return this.lightOn;
    }

    @Override
    public boolean isSwitchedOff() {
        return !this.lightOn;
    }
}
