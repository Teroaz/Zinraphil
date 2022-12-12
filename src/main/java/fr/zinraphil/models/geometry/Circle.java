package fr.zinraphil.models.geometry;

import fr.zinraphil.models.transformations.ICentralSymmetry;
import fr.zinraphil.models.transformations.IHomothethy;
import fr.zinraphil.models.transformations.ITranslation;

import java.awt.*;

public class Circle extends Shape<Circle> implements IDrawable, ITranslation, IHomothethy, ICentralSymmetry {

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

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public int compareTo(Shape o) {
        if (this.getClass() != o.getClass()) return this.getClass().getName().compareTo(o.getClass().getName());

        Circle c = (Circle) o;
//        if (this.center.compareTo(c.getCenter()) != 0) return this.center.compareTo(c.getCenter());
        return this.radius - c.getRadius();
    }

    public void applyTranslation(int deltaX, int deltaY) {
        this.center.applyTranslation(deltaX, deltaY);
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(center.getX() - radius, center.getY() - radius, radius * 2, radius * 2);
    }

    @Override
    public void applyHomothety(float k) {
        this.radius *= k;
    }

    @Override
    public void applyCentralSymmetry(Point p) {
        int x1 = p.getX() + (p.getX() - center.getX());
        int y1 = p.getY() + (p.getY() - center.getY());
        this.center.setX(x1);
        this.center.setY(y1);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }
}
