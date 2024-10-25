package ch.hslu.oop.sw05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoSw5 {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoSw5.class);

    public void runDemo() {
        this.demoGeometryExercise();
        this.demoChemicalStructuresExercise();
        this.demoCountingSwitchable();
    }

    public void demoGeometryExercise() {
        LOGGER.info("");
        LOGGER.info("==========================================================START");
        LOGGER.info("");

        // Test Circle
        Circle circle = new Circle(0, 0, 10);
        LOGGER.info("Circle Perimeter: {}", circle.getPerimeter());
        LOGGER.info("Circle Area: {}", circle.getArea());
        circle.setDiameter(20);
        LOGGER.info("Updated Circle Perimeter: {}", circle.getPerimeter());
        LOGGER.info("Updated Circle Area: {}", circle.getArea());

        LOGGER.info("---------------------------------------------------------");

        // Test Rectangle
        Rectangle rectangle = new Rectangle(0, 0, 10, 5);
        LOGGER.info("Rectangle Perimeter: {}", rectangle.getPerimeter());
        LOGGER.info("Rectangle Area: {}", rectangle.getArea());
        rectangle.changeDimension(15, 7);
        LOGGER.info("Updated Rectangle Perimeter: {}", rectangle.getPerimeter());
        LOGGER.info("Updated Rectangle Area: {}", rectangle.getArea());

        LOGGER.info("---------------------------------------------------------");

        // Test Square
        Square square = new Square(0, 0, 10);
        LOGGER.info("Square Perimeter: {}", square.getPerimeter());
        LOGGER.info("Square Area: {}", square.getArea());
        square.setLength(15);
        LOGGER.info("Updated Square Perimeter: {}", square.getPerimeter());
        LOGGER.info("Updated Square Area: {}", square.getArea());

        LOGGER.info("---------------------------------------------------------");
        LOGGER.info("");
        LOGGER.info("==========================================================END");
        LOGGER.info("");
        LOGGER.info("");
    }

    public void demoChemicalStructuresExercise() {
        LOGGER.info("");
        LOGGER.info("==========================================================START");
        LOGGER.info("");

        // Test Lead
        Lead lead = new Lead();
        LOGGER.info("Test if lead is solid -> result: {}", lead.evaluateState(100));
        LOGGER.info("Test if lead is liquid -> result: {}", lead.evaluateState(1000));
        LOGGER.info("Test if lead is gas -> result: {}", lead.evaluateState(2000));

        LOGGER.info("---------------------------------------------------------");

        // Test Mercury
        Mercury mercury = new Mercury();
        LOGGER.info("Test if mercury is solid -> result: {}", mercury.evaluateState(-100));
        LOGGER.info("Test if mercury is liquid -> result: {}", mercury.evaluateState(100));
        LOGGER.info("Test if mercury is gas -> result: {}", mercury.evaluateState(1000));

        LOGGER.info("---------------------------------------------------------");

        // Test Oxygen
        Oxygen oxygen = new Oxygen();
        LOGGER.info("Test if oxygen is solid -> result: {}", oxygen.evaluateState(-300));
        LOGGER.info("Test if oxygen is liquid -> result: {}", oxygen.evaluateState(-200));
        LOGGER.info("Test if oxygen is gas -> result: {}", oxygen.evaluateState(-100));

        LOGGER.info("---------------------------------------------------------");

        // Test Nitrogen
        Nitrogen nitrogen = new Nitrogen();
        LOGGER.info("Test if nitrogen is solid -> result: {}", nitrogen.evaluateState(-250));
        LOGGER.info("Test if nitrogen is liquid -> result: {}", nitrogen.evaluateState(-200));
        LOGGER.info("Test if nitrogen is gas -> result: {}", nitrogen.evaluateState(-150));

        LOGGER.info("---------------------------------------------------------");
        LOGGER.info("");
        LOGGER.info("==========================================================END");
        LOGGER.info("");
        LOGGER.info("");
    }

    public void demoCountingSwitchable() {
        LOGGER.info("");
        LOGGER.info("==========================================================START");
        LOGGER.info("");
        DemoImplementationCountingSwitchable demo = new DemoImplementationCountingSwitchable();
        LOGGER.info("Initial count: {}", demo.getSwitchCount());
        LOGGER.info("Turning on and off switchable");
        demo.switchOn();
        demo.switchOff();
        LOGGER.info("Result count: {}", demo.getSwitchCount());

        LOGGER.info("---------------------------------------------------------");
        LOGGER.info("");
        LOGGER.info("==========================================================END");
        LOGGER.info("");
        LOGGER.info("");
    }
}
