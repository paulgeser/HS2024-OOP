package ch.hslu.oop.sw11.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CsvReader {

    private static final Logger LOG = LoggerFactory.getLogger(CsvReader.class);

    private final String csvFilename = "resources/netatmo-export-202301-202304.csv";

    public void readCsvFile() throws IOException {
        TemperatureCurve temperatureCurve = new TemperatureCurve();
        if (new File(csvFilename).exists()) {
            try (BufferedReader br =
                         new BufferedReader(new InputStreamReader(
                                 new FileInputStream(csvFilename), StandardCharsets.UTF_8))
            ) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] splitLine = line.split(";");
                    double temperature = Double.parseDouble(splitLine[2]);
                    LocalDateTime timestamp =
                            LocalDateTime.parse(splitLine[1],
                                    DateTimeFormatter.ofPattern("\"yyyy/MM/dd HH:mm:ss\""));
                    LOG.info("Temperature: {}, Timestamp: {}", temperature, timestamp);
                    temperatureCurve.addMeasuringPoint(new MeasuringPoint(Temperature.createFromCelsius(temperature), timestamp));
                }
            } catch (IOException ioe) {
                LOG.error(ioe.getMessage(), ioe);
            }
        }
        LOG.info("Max temperature: {}", temperatureCurve.getMaxTemperature());
        LOG.info("Min temperature: {}", temperatureCurve.getMinTemperature());
        LOG.info("Average temperature: {}", temperatureCurve.getAverageCelciusTemperature());
        LOG.info("Count of temperature entries: {}", temperatureCurve.getCount());
    }
}
