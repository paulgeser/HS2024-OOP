package ch.hslu.oop.sw04;

public class LineXY {

    private int p1x, p1y, p2x, p2y;

    public LineXY(final int p1x, final int p1y, final int p2x, final int p2y) {
        this.p1x = p1x;
        this.p1y = p1y;
        this.p2x = p2x;
        this.p2y = p2y;
    }

    public int getP1x() {
        return p1x;
    }

    public void setP1x(final int p1x) {
        this.p1x = p1x;
    }

    public int getP1y() {
        return p1y;
    }

    public void setP1y(final int p1y) {
        this.p1y = p1y;
    }

    public int getP2x() {
        return p2x;
    }

    public void setP2x(final int p2x) {
        this.p2x = p2x;
    }

    public int getP2y() {
        return p2y;
    }

    public void setP2y(final int p2y) {
        this.p2y = p2y;
    }

    public Point getPoint1() {
        return new Point(p1x, p1y);
    }

    public Point getPoint2() {
        return new Point(p2x, p2y);
    }

    public void setPoint1(final Point point1){
        this.p1x = point1.getX();
        this.p1y = point1.getY();
    }

    public void setPoint2(final Point point2){
        this.p2x = point2.getX();
        this.p2y = point2.getY();
    }
}
