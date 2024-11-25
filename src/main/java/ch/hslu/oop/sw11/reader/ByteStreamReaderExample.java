package ch.hslu.oop.sw11.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Exercise 1c)
 */

public class ByteStreamReaderExample {

    private static final Logger LOG = LoggerFactory.getLogger(ByteStreamReaderExample.class);

    public static void main(String[] args) {
        String fileName = "resources/data.bin";

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            try {
                int intValue = dis.readInt();
                LOG.info("Read int value: {}", intValue);
            } catch (EOFException e) {
                LOG.info("No further int data available. Error: {}", e.getMessage());
            }

            try {
                byte byteValue = dis.readByte();
                LOG.info("Read byte value: {}", byteValue);
            } catch (EOFException e) {
                LOG.info("No further byte data available. Error: {}", e.getMessage());
            }

            try {
                float floatValue = dis.readFloat();
                LOG.info("Read float value: {}", floatValue);
            } catch (EOFException e) {
                LOG.info("No further float data available. Error: {}", e.getMessage());
            }
        } catch (IOException e) {
            LOG.info(e.getMessage());
        }
    }
}

