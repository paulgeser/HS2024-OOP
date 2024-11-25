package ch.hslu.oop.sw11.csv;

import java.time.LocalDateTime;

public class MeasuringPoint implements Comparable<MeasuringPoint> {

    private final Temperature temperature;
    private final LocalDateTime localDateTime;

    public MeasuringPoint(Temperature temperature, LocalDateTime localDateTime) {
        this.temperature = temperature;
        this.localDateTime = localDateTime;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    @Override
    public int compareTo(MeasuringPoint o) {
        int resultTemperature = Double.compare(this.getTemperature().getTemperatureCelcius(), o.getTemperature().getTemperatureCelcius());
        if (resultTemperature != 0) {
            return this.localDateTime.compareTo(o.getLocalDateTime());
        } else {
            return resultTemperature;
        }
    }


    @Override
    public String toString() {
        return "MeasuringPoint{" + "temperature=" + temperature + ", localDateTime=" + localDateTime + '}';
    }
}
