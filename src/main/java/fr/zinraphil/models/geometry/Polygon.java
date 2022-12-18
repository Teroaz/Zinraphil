package fr.zinraphil.models.geometry;

import fr.zinraphil.models.geometry.angle.Angle;
import fr.zinraphil.models.transformations.*;
import fr.zinraphil.utils.Coordinates;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Polygon extends Shape<Polygon> implements IRotation, ITranslation, ICentralSymmetry, IDrawable, IHomothethy, IAxialSymmetry {

    private ArrayList<Point> points;

    public Polygon(ArrayList<Point> points) {
        this.points = points;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public Point getCenter () {
        double x = 0;
        double y = 0;
        for (Point p : points) {
            x += p.getX();
            y += p.getY();
        }
        return new Point((int) (x / points.size()), (int) (y / points.size()));
    }

    public double getArea() {
        // Calculate the area of a polygon using the Shoelace formula
        // https://en.wikipedia.org/wiki/Shoelace_formula
        double area = 0;
        for (int i = 0; i < points.size(); i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % points.size());
            area += p1.getX() * p2.getY() - p2.getX() * p1.getY();
        }
        return Math.abs(area) / 2;
    }

    public double getPerimeter() {
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
    public void applyRotation(Angle angle) {

        Point center = getCenter();

        for (Point p : points) {
            Line l = new Line(center, p);
            l.applyRotation(angle);
        }

    }

    @Override
    public void applyTranslation(int deltaX, int deltaY) {
        for (Point p : this.points) {
            p.applyTranslation(deltaX, deltaY);
        }
    }


    @Override
    public void applyHomothety(float k) {
        for (Point p : this.points) {
            p.setX((int) (p.getX() * k));
            p.setY((int) (p.getY() * k));
        }
    }

    @Override
    public void applyAxialSymmetry(Axis axis) {
        for (Point p : this.points) {
            p.applyAxialSymmetry(axis);
        }
    }

    @Override
    public void applyCentralSymmetry(Point p) {
        for (Point p1 : this.points) {
            int x1 = p.getX() + (p.getX() - p1.getX());
            int y1 = p.getY() + (p.getY() - p1.getY());
            p1.setX(x1);
            p1.setY(y1);
        }
    }

    @Override
    public void draw(Graphics g) {
        for (int i = 0; i < points.size(); i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % points.size());
            g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        }
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "points=" + points +
                '}';
    }
}

