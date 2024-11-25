package ch.hslu.oop.sw11.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Exercise 1d)
 */

public class MultiTypeStreamExample {

    private static final Logger LOG = LoggerFactory.getLogger(MultiTypeStreamExample.class);

    public static void main(String[] args) {
        String fileName = "resources/multi_data.bin";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            int intValue = 24;
            double doubleValue = 3.14159;
            char charValue = 'A';
            float floatValue = 2.71f;
            dos.writeInt(intValue);
            dos.writeDouble(doubleValue);
            dos.writeChar(charValue);
            dos.writeFloat(floatValue);
            LOG.info("Different elementary types were written into the file.");
            LOG.info("Written values: Integer={}, Double={}, Char={}, Float{} ", intValue, doubleValue, charValue, floatValue);
            LOG.info("------------------------------------");

        } catch (IOException e) {
            LOG.error(e.getMessage());
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            int intValue = dis.readInt();
            double doubleValue = dis.readDouble();
            char charValue = dis.readChar();
            float floatValue = dis.readFloat();
            LOG.info("Read values: Integer={}, Double={}, Char={}, Float{} ", intValue, doubleValue, charValue, floatValue);
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }
}

