package ch.hslu.oop.sw05;

public class Square extends Shape {

    private int length;

    public Square(final int x, final int y, final int length) {
        super(x, y);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(final int length) {
        this.length = length;
    }

    @Override
    public int getPerimeter() {
        return 4 * length;
    }

    @Override
    public int getArea() {
        return (int) Math.pow(length, 2);
    }

}
