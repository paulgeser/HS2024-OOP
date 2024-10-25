package ch.hslu.oop.sw05;

public abstract class Shape {

    private int x;
    private int y;

    public Shape(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public void move (final int newX, final int newY) {
        this.x = newX;
        this.y = newY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Abstract methods for perimeter and area
    public abstract int getPerimeter();
    public abstract int getArea();
}
