package ch.hslu.oop.sw11.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Scanner;

/**
 * Exercise 1e)
 */

public class TemperatureBinaryWriter {

    private static final Logger LOG = LoggerFactory.getLogger(TemperatureBinaryWriter.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "resources/temperatures.bin";

        LOG.info("Please enter the amount of temperatures you would like to store:");
        int count = scanner.nextInt();

        double[] temperatures = new double[count];
        LOG.info("Please enter the temperatures values");
        for (int i = 0; i < count; i++) {
            temperatures[i] = scanner.nextDouble();
        }

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(count);
            for (double temp : temperatures) {
                dos.writeDouble(temp);
            }
            LOG.info("Temperature values were written into the file");
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }
}