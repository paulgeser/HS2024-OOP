package ch.hslu.oop.sw11.reader;

import ch.hslu.oop.sw11.csv.CsvReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Exercise 1b)
 */

public class ByteStreamExample {

    private static final Logger LOG = LoggerFactory.getLogger(ByteStreamExample.class);

    public static void main(String[] args) {
        String fileName = "resources/data.bin";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            int value = 12345;
            dos.writeInt(value);
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }
}
