package fr.zinraphil.models.geometry;

import fr.zinraphil.models.transformations.axial_symetry.Axis;

import java.awt.*;

import static fr.zinraphil.controllers.ZinraphilController.IMAGE_SIZE;

public class Circle extends Shape<Circle> implements IDrawable , ITranslation , Isymetrieaxiale {

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
    public void translation(int deltaX, int deltaY) {
        this.center.translation(deltaX, deltaY);
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(center.getX() - radius, center.getY() - radius, radius * 2, radius * 2);
    }

    @Override
    public void symetrieaxiale(Axis axis) {
        if (axis == Axis.X) {
            this.center.setY(IMAGE_SIZE - this.center.getY());
        } else {
            this.center.setX(IMAGE_SIZE - this.center.getX());
        }

    }
}
