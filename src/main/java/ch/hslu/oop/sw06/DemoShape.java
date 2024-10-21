package ch.hslu.oop.sw06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoShape {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoShape.class);


    public DemoShape() {
    }

    public void runDemo() {
        Shape shape1 = new Rectangle(1, 1, 2, 3);
        Shape shape2 = new Circle(1, 1, 2);

        shape1.move(1, 2);
        shape2.move(1, 2);

        if (shape2 instanceof Circle) {
            LOGGER.info("{}", ((Circle) shape2).getDiameter());
        }
    }
}
