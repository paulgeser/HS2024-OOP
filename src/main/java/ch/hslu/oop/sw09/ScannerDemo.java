package ch.hslu.oop.sw09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class ScannerDemo {

    private static final Logger LOG = LoggerFactory.getLogger(ScannerDemo.class);

    public void tryScanner() {
        String input;
        Scanner scanner = new Scanner(System.in);
        do {
            LOG.info("Bitte Temperatur eingeben (oder 'exit' zum Beenden): ");
            input = scanner.next();
            try {
                float value = Float.valueOf(input);
                LOG.info("Value '{}' was provided", input);
            } catch (NumberFormatException e) {
                if (!input.equals("exit")) {
                    LOG.error("Not valid input: {}!", input);
                }
            }
        } while (!"exit".equals(input));
        LOG.info("Programm beendet.");
    }
}
