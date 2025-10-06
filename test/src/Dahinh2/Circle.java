package Dahinh2;

import java.util.Objects;

public class Circle extends Shape {
    protected double radius;
    protected Point center;

    /**
     *cmt.
     */
    public Circle() {
        super();
        this.center =  new Point(0, 0);
        this.radius = 0;
    }

    /**
     *cmt.
     */
    public Circle(double radius) {
        super();
        this.radius = radius;
        this.center = new Point(0, 0);
    }

    /**
     *cmt.
     */
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
        this.center = new Point(0, 0);
    }

    /**
     *cmt.
     */
    public Circle(Point center, double radius, String color, boolean filled) {
        super(color, filled);
        this.center = center;
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * radius * 2;
    }

    @Override
    public String toString() {
        return String.format(
                "Circle[center=%s,radius=%.1f,color=%s,filled=%b]",
                this.center.toString(), radius, color, filled);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Circle) {
            Circle circle = (Circle) o;
            return this.center.equals(circle.center) &&  this.radius == circle.radius;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }
}
