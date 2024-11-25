package ch.hslu.oop.sw11;

import ch.hslu.oop.sw10.temperature.Temperature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileEditor {

    private static final Logger LOG = LoggerFactory.getLogger(FileEditor.class);

    public static void main(String[] args) throws IOException {

    }

    public void testWriteInteger() throws IOException {
        final Writer writer = new FileWriter("text.txt", StandardCharsets.UTF_8);
        writer.write("98");
        writer.close();
    }

    public void testReadInteger() throws IOException {
        /*final Reader reader = new FileReader("text.txt", StandardCharsets.UTF_8);
        int result = reader.read();

        LOG.info("{}", result);*/

        final DataInputStream dis = new DataInputStream(
                new FileInputStream("text.txt"));
        final int value = dis.readInt();
        dis.close();
        LOG.info("{}", value);
    }

    public void exampleReader(String file) {
        if (new File(file).exists()) {
            try (BufferedReader br =
                         new BufferedReader(new InputStreamReader(
                                 new FileInputStream(file), StandardCharsets.UTF_8))
            ) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException ioe) {
                LOG.error(ioe.getMessage(), ioe);
            }
        }
    }
/*
    private void readDouble() throws IOException {
        final DataInputStream dis = new DataInputStream(
                new FileInputStream("c:\\demo.dat"));
        final double value = dis.readDouble();
        dis.close();
    }

    public void writeTextFile(final String file) {
        try (PrintWriter pw =
                     new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                             new FileOutputStream(file), StandardCharsets.UTF_8)));
        ) {
            pw.println("Euro € und Umlaute äöü - alles da!");
            pw.println("Plattformunabhängig fix mit UTF-8 encodiert!");
            pw.flush();
        } catch (IOException ioe) {
            LOG.error(ioe.getMessage(), ioe);
        }
    }*/
}
