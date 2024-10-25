package ch.hslu.oop.sw05;

public class Circle extends Shape {

    private int diameter;

    public Circle(final int x, final int y, final int diameter) {
        super(x, y);
        this.diameter = diameter;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(final int diameter) {
        this.diameter = diameter;
    }

    @Override
    public int getPerimeter() {
        return (int) Math.round(Math.PI * diameter);
    }

    @Override
    public int getArea() {
        int radius = diameter / 2;
        return (int) Math.round(Math.PI * radius * radius);
    }
}
