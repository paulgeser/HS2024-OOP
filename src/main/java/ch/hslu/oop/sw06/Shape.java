package ch.hslu.oop.sw06;

public abstract class Shape {

    private int x;
    private int y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move (int newX, int newY) {
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
