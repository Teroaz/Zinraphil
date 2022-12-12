package fr.zinraphil.models.geometry;

import fr.zinraphil.models.geometry.angle.Angle;
import fr.zinraphil.models.transformations.axial_symetry.Axis;

import java.awt.*;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Line extends Shape<Line> implements IRotation, ITranslation, Isymetrieaxiale, Isymetriecentrale, IDrawable {

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
    public int compareTo(Shape o) {
        if (this.getClass() != o.getClass()) return this.getClass().getName().compareTo(o.getClass().getName());

        Line l = (Line) o;
        if (this.p1.compareTo(l.getP1()) != 0) return this.p1.compareTo(l.getP1());
        return this.p2.compareTo(l.getP2());
    }

    public void translation(int deltaX, int deltaY) {
        p1.translation(deltaX, deltaY);
        p2.translation(deltaX, deltaY);
    }


    @Override
    public void rotation(Angle angle) {
        this.p2.setX((int) (this.p2.getX() * cos(angle.getDegree())));
        this.p2.setY((int) (this.p2.getY() * sin(angle.getDegree())));

    }

    @Override
    public void symetrieaxiale(Axis axis) {
        this.p1.symetrieaxiale(axis);
        this.p2.symetrieaxiale(axis);
    }

    @Override
    public void symetriecentrale() {
        p1.setX(-p1.getX());
        p2.setX(-p2.getX());
        p1.setY(-p1.getY());
        p2.setY(-p2.getY());
    }
}

