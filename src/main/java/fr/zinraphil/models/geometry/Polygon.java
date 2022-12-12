package fr.zinraphil.models.geometry;

import fr.zinraphil.models.geometry.angle.Angle;
import fr.zinraphil.models.transformations.axial_symetry.Axis;

import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.cos;

public class Polygon extends Shape<Polygon> implements AxialSymmetryShape, IRotation, ITranslation, Isymetrieaxiale, Isymetriecentrale {

    private ArrayList<Point> points;

    public Polygon(ArrayList<Point> points) {
        this.points = points;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public double area() {
        // Calculate the are of a polygon using the Shoelace formula
        // https://en.wikipedia.org/wiki/Shoelace_formula
        double area = 0;
        for (int i = 0; i < points.size(); i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % points.size());
            area += p1.getX() * p2.getY() - p2.getX() * p1.getY();
        }
        return Math.abs(area) / 2;
    }

    public double perimeter() {
        double perimeter = 0;
        for (int i = 0; i < points.size(); i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % points.size());
            perimeter += Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
        }
        return perimeter;
    }

    @Override
    public int compareTo(Shape o) {
        if (this.getClass() != o.getClass()) return this.getClass().getName().compareTo(o.getClass().getName());

        Polygon p = (Polygon) o;
        int samePoints = 0;
        if (this.points.size() != p.getPoints().size()) return this.points.size() - p.getPoints().size();
        for (Point p1 : this.points) {
            for (Point p2 : p.getPoints()) {
                if (p1.compareTo(p2) == 0) samePoints++;
            }
        }

        return samePoints - this.points.size();
    }

    @Override
    public void rotation(Angle angle) {
        for (Point p : this.points) {
            p.setX((int) (p.getX() * cos(angle.getRadian())));
            p.setY((int) (p.getY() * cos(angle.getRadian())));

        }
    }

    @Override
    public void translation(int deltaX, int deltaY) {
        for (Point p : this.points) {
            p.translation(deltaX, deltaY);
        }
    }

    @Override
    public void homothety(float k) {
        for (Point p : this.points) {
            p.setX((int) (p.getX() * k));
            p.setY((int) (p.getY() * k));
        }
    }

    public void symetrieaxiale(Axis axis) {
        for (Point p : this.points) {
            p.symetrieaxiale(axis);
        }
    }

    @Override
    public void symetriecentrale(Point p) {
        for (Point p1 : this.points) {
            int x1 = p.getX() + (p.getX() - p1.getX());
            int y1 = p.getY() + (p.getY() - p1.getY());
            p1.setX(x1);
            p1.setY(y1);
        }
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "points=" + points +
                '}';
    }

    @Override
    public void draw(Graphics g) {
        for (int i = 0; i < points.size(); i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % points.size());
            g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        }
    }
}

