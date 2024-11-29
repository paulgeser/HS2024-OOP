/*
 * Copyright 2024 Roland Gisler, HSLU Informatik, Switzerland
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.oop;

import ch.hslu.oop.sw10.temperature.ScannerDemo;
import ch.hslu.oop.sw11.csv.CsvReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Main-Applikation für {@link ch.hslu.oop}.
 */
public final class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    /**
     * Privater Konstruktor.
     */
    private Main() {
    }

    /**
     * Main-Methode.
     *
     * @param args Startargumente.
     */
    public static void main(final String[] args) throws IOException {
        /*LOGGER.info("{} befindet sich in Quadrant: {}", point, quadrant);*/

        LOGGER.info("Welcome to OOP!");
        /*DatentypTest test1 = new DatentypTest();
        test1.execute();*/

        /*Iteration i = new Iteration();
        i.printBox(18, 6);
        i.printBoxShort(18, 6);
        i.printBoxUltraShort(18, 6);*/

        /*LinePoint linePoint = new LinePoint(new Point(0,1), new Point(10,11));
        LOGGER.info(linePoint.getP1().getX());
        linePoint.getP1().setX(100);
        LOGGER.info(linePoint.getP1().getX());*/

        /*DemoSw5 demo = new DemoSw5();
        demo.runDemo();*/

        /*DemoShape demoShape = new DemoShape();
        demoShape.runDemo();*/

        /*ScannerDemo scannerDemo = new ScannerDemo();
        scannerDemo.tryScanner();*/

        /*CsvReader reader = new CsvReader();
        reader.readCsvFile();*/
    }
}
