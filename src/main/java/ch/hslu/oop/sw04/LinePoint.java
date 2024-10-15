package ch.hslu.oop.sw04;

public class LinePoint {

    private Point p1;
    private Point p2;

    public LinePoint(final Point p1, final Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getP1() {
        return new Point(this.p1.getX(), this.p1.getY());
    }

    public void setP1(final Point p1) {
        this.p1 = p1;
    }

    public final Point getP2() {
        return new Point(this.p2.getX(), this.p2.getY());
    }

    public void setP2(final Point p2) {
        this.p2 = p2;
    }
}
