package ch.hslu.oop.sw08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TemperatureCurve {

    private Collection<Temperature> temperatures = new ArrayList<Temperature>();

    public void addTemperature(Temperature t) {
        this.temperatures.add(t);
    }

    public void clear() {
        this.temperatures.clear();
    }

    public int getCount() {
        return this.temperatures.size();
    }

    public Temperature getMaxTemperature() {
        if (this.getCount() == 0) return null;
        return Collections.max(this.temperatures);
    }

    public Temperature getMinTemperature() {
        if (this.getCount() == 0) return null;
        return Collections.min(this.temperatures);
    }

    public double getAverageCelciusTemperature() {
        double temperaturesSum = 0.0;
        for (Temperature temperature : this.temperatures) {
            temperaturesSum += temperature.getTemperatureCelcius();
        }
        return temperaturesSum / this.getCount();
    }
}
