package ch.hslu.oop.sw04;

public class Motor implements Switchable {

    private boolean engineOn = false;
    private int rpm = 0;
    final private int MAX_RPM = 3000;

    @Override
    public void switchOn() {
        this.engineOn = true;
        this.rpm = MAX_RPM;
    }

    @Override
    public void switchOff() {
        this.engineOn = false;
        this.rpm = 0;
    }

    @Override
    public boolean isSwitchedOn() {
        return this.engineOn;
    }

    @Override
    public boolean isSwitchedOff() {
        return !this.engineOn;
    }
}
