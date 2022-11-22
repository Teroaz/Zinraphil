package fr.zinraphil.models.geometry;

public class Circle extends Shape<Circle> {

    private Point center;
    private int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public int compareTo(Circle o) {
        if (this.center.compareTo(o.getCenter()) != 0) return this.center.compareTo(o.getCenter());
        return this.radius - o.getRadius();
    }
}
