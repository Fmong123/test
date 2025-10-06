package Dahinh2;

import java.util.Objects;

public class Point {
    private double pointX;
    private double pointY;

    public Point() {
        pointX = 0;
        pointY = 0;
    }

    public Point(double pointX, double pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    /**
     *cmt.
     */
    public double distance(Point newPoint) {
        double dx = this.pointX - newPoint.pointX;
        double dy = this.pointY - newPoint.pointY;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Point) {
            Point p = (Point) o;
            return this.pointX == p.pointX && this.pointY == p.pointY;
        } else  {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointX, pointY);
    }

    @Override
    public String toString() {
        return String.format("(%.1f,%.1f)", pointX, pointY);
    }
}
