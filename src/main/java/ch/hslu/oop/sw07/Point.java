package ch.hslu.oop.sw07;

import java.util.Objects;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveRelative(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void moveRelative(Point point) {
        this.x += point.getX();
        this.y += point.getY();
    }

    public void moveRelative(double angle, double magnitude) {
        int deltaX = (int) Math.round(magnitude * Math.cos(angle));
        int deltaY = (int) Math.round(magnitude * Math.sin(angle));
        this.x += deltaX;
        this.y += deltaY;
    }

    public int getQuadrant() {
        if (x == 0 || y == 0) {
            return 0;
        } else if (x > 0 && y > 0) {
            return 1;
        } else if (x < 0 && y > 0) {
            return 2;
        } else if (x < 0 && y < 0) {
            return 3;
        } else if (x > 0 && y < 0) {
            return 4;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }

    @Override
    public final boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        return (object instanceof Point p) && (p.getX() == this.x) && (p.getY() == this.y);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.x, this.y);
    }
}