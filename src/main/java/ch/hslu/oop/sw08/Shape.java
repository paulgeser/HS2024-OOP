package ch.hslu.oop.sw08;

public abstract class Shape {

    private int x;
    private int y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public final void move (final int newX, final int newY) {
        this.x = newX;
        this.y = newY;
    }

    final public int getX() {
        return x;
    }

    final public int getY() {
        return y;
    }

    // Abstract methods for perimeter and area
    public abstract int getPerimeter();
    public abstract int getArea();
}
