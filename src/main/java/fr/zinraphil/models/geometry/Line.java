package fr.zinraphil.models.geometry;

import fr.zinraphil.models.transformations.axial_symetry.AxialSymmetryShape;
import fr.zinraphil.models.transformations.axial_symetry.Axis;

public class Line extends Shape<Line> implements AxialSymmetryShape {

    private Point p1;
    private Point p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public double length() {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }
    
    public double area() {
        return 0;
    }

    public double perimeter() {
        return length();
    }

    @Override
    public int compareTo(Line o) {
        if (this.p1.compareTo(o.getP1()) != 0) return this.p1.compareTo(o.getP1());
        return this.p2.compareTo(o.getP2());
    }

    @Override
    public void applyAxialSymmetry(Axis axis) {
        if (axis == Axis.X) {
            p1.setY(-p1.getY());
            p2.setY(-p2.getY());
        } else if (axis == Axis.Y) {
            p1.setX(-p1.getX());
            p2.setX(-p2.getX());
        }
    }
}
