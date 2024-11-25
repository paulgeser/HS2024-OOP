package ch.hslu.oop.sw11.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Exercise 1f)
 */

public class TemperatureBinaryReader {

    private static final Logger LOG = LoggerFactory.getLogger(TemperatureBinaryReader.class);

    public static void main(String[] args) {
        String fileName = "resources/temperatures.bin";

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            int count = dis.readInt(); // Anzahl der Werte
            double[] temperatures = new double[count];

            for (int i = 0; i < count; i++) {
                temperatures[i] = dis.readDouble();
            }

            LOG.info("Read temperature values from file:");
            for (double temp : temperatures) {
                LOG.info("{}", temp);
            }
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }
}

