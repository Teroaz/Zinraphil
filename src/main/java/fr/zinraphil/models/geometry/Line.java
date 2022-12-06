package fr.zinraphil.models.geometry;

import fr.zinraphil.models.geometry.angle.Angle;

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
    public void symetrieaxiale() {
        // symmetry of a line with respect to the axis
        int x1 = this.p1.getX();
        int y1 = this.p1.getY();
        int x2 = this.p2.getX();
        int y2 = this.p2.getY();
        this.p1.setX(x1);
        this.p1.setY(y2);
        this.p2.setX(x2);
        this.p2.setY(y1);


    }

    @Override
    public void symetriecentrale() {
        p1.setX(-p1.getX());
        p2.setX(-p2.getX());
        p1.setY(-p1.getY());
        p2.setY(-p2.getY());
    }

    @Override
    public String toString() {
        return "Line{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
}

