package ch.hslu.oop.sw12.temperature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * The {@code ScannerDemo} class demonstrates how to use a {@code Scanner} to interact
 * with the user via the console for temperature input. It manages a {@code TemperatureCurve}
 * to track temperatures and logs relevant events.
 */
public class ScannerDemo {

    // Logger instance for logging messages
    private static final Logger LOG = LoggerFactory.getLogger(ScannerDemo.class);

    // TemperatureCurve instance to manage and track temperature data
    private final TemperatureCurve temperatureCurve = new TemperatureCurve();

    /**
     * Constructs a {@code ScannerDemo} instance and attaches a property change listener
     * to the {@code TemperatureCurve} to handle temperature-related events.
     */
    public ScannerDemo() {
        this.temperatureCurve.addPropertyChangeListener(this::handleTemperatureCurveEvent);
    }

    /**
     * Demonstrates the usage of a {@code Scanner} to input temperatures from the user.
     * The user can input temperature values, which are added to the {@code TemperatureCurve}.
     * The program logs and handles invalid input, and it stops when the user types 'exit'.
     */
    public void tryScanner() {
        String input;
        Scanner scanner = new Scanner(System.in); // Create a Scanner to read user input
        do {
            LOG.info("Please enter a temperature (or 'exit' to quit): ");
            input = scanner.next();
            try {
                // Attempt to parse the input as a double and add it to the temperature curve
                double value = Double.valueOf(input);
                LOG.info("Value '{}' was provided", input);
                this.temperatureCurve.addTemperature(Temperature.createFromCelsius(value));
            } catch (NumberFormatException e) {
                // Handle invalid input (non-numeric values) excluding the 'exit' command
                if (!input.equals("exit")) {
                    LOG.error("Not valid input: {}!", input);
                }
            }
        } while (!"exit".equals(input)); // Continue until the user types 'exit'

        // Log the final statistics after exiting the loop
        LOG.info("--- Programme stats ---");
        LOG.info("Max temperature: {}", this.temperatureCurve.getMaxTemperature());
        LOG.info("Min temperature: {}", this.temperatureCurve.getMinTemperature());
        LOG.info("Average temperature: {}", this.temperatureCurve.getAverageCelciusTemperature());
        LOG.info("Count of temperature entries: {}", this.temperatureCurve.getCount());
        LOG.info("--- Programme finished ---");


        LOG.info("additional-----");
        LOG.info("-");
        LOG.info("-");
        LOG.info("-");
        LOG.info("-");
        LOG.info("{}", this.temperatureCurve.getMaxTemperatureByStream());
        LOG.info("{}", this.temperatureCurve.getMinTemperatureByStream());
        LOG.info("{}", this.temperatureCurve.getTemperatureListAsString());
        LOG.info("{}", this.temperatureCurve.getTemperaturesBetween20And60());
    }

    /**
     * Handles temperature change events from the {@code TemperatureCurve}.
     * Logs details about the type of event, the new temperature, and the previous temperature.
     *
     * @param event the temperature event to handle
     */
    private void handleTemperatureCurveEvent(TemperatureEventInterface event) {
        LOG.info(
                "New {} temperature was found with value of {}, old value was {}",
                event.getEventType(),
                event.getNewValue().getTemperatureCelcius(),
                event.getOldValue() != null ? event.getOldValue().getTemperatureCelcius() : "no previous value"
        );
    }
}
