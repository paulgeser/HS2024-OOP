package ch.hslu.oop.sw05;

public class Square extends Shape {

    private final Rectangle rectangle;

    public Square(final int x, final int y, final int length) {
        super(x, y);
        rectangle = new Rectangle(x, y, length, length);
    }

    public int getLength() {
        return rectangle.getHeight();
    }

    public void setLength(final int length) {
        rectangle.changeDimension(length, length);
    }

    @Override
    public int getPerimeter() {
        return rectangle.getPerimeter();
    }

    @Override
    public int getArea() {
        return rectangle.getArea();
    }
}
