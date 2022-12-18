package fr.zinraphil.models.geometry;

import fr.zinraphil.models.geometry.angle.Angle;
import fr.zinraphil.models.transformations.*;

import java.awt.*;
import java.util.ArrayList;

/**
 * Represents a polygon on a two-dimensional plane.
 */
public class Polygon extends Shape<Polygon> implements IRotation, ITranslation, ICentralSymmetry, IDrawable, IHomothethy, IAxialSymmetry {

    // Instance variable for the list of points that make up the polygon.
    private ArrayList<Point> points;

    /**
     * Constructs a new Polygon object with the given list of points.
     *
     * @param points the list of points that make up the polygon
     */
    public Polygon(ArrayList<Point> points) {
        this.points = points;
    }

    /**
     * Returns the list of points that make up the polygon.
     *
     * @return the list of points that make up the polygon
     */
    public ArrayList<Point> getPoints() {
        return points;
    }

    /**
     * Returns the center point of the polygon.
     *
     * @return the center point of the polygon
     */
    public Point getCenter() {
        double x = 0;
        double y = 0;
        for (Point p : points) {
            x += p.getX();
            y += p.getY();
        }
        return new Point((int) (x / points.size()), (int) (y / points.size()));
    }

    /**
     * Returns the area of the polygon.
     *
     * @return the area of the polygon
     */
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

    /**
     * Calculates and returns the perimeter of the polygon.
     *
     * @return the perimeter of the polygon
     */
    public double getPerimeter() {
        double perimeter = 0;
        for (int i = 0; i < points.size(); i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % points.size());
            perimeter += Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
        }
        return perimeter;
    }

    /**
     * Compares this polygon to another shape object. If the object is not a polygon, it is considered less than this polygon.
     * If the object is a polygon, the two polygons are compared based on the number of points they have in common. If the
     * number of points in common is equal, the polygons are considered equal.
     *
     * @param o the shape object to compare to this polygon
     * @return a negative integer, zero, or a positive integer as this polygon is less than, equal to, or greater than the
     * specified object
     */
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

    /**
     * Rotates the polygon around its center by a given angle.
     *
     * @param angle the angle to rotate the polygon by
     */
    @Override
    public void applyRotation(Angle angle) {

        Point center = getCenter();

        for (Point p : points) {
            Line l = new Line(center, p);
            l.applyRotation(angle);
        }

    }

    /**
     * Translates the polygon by a given amount in the x and y direction.
     *
     * @param deltaX the amount to translate the polygon in the x direction
     * @param deltaY the amount to translate the polygon in the y direction
     */
    @Override
    public void applyTranslation(int deltaX, int deltaY) {
        for (Point p : this.points) {
            p.applyTranslation(deltaX, deltaY);
        }
    }


    /**
     * Applies a homothety transformation to the polygon.
     *
     * @param k the scale factor to apply to the x and y coordinates of each point in the polygon
     */
    @Override
    public void applyHomothety(float k) {
        for (Point p : this.points) {
            p.setX((int) (p.getX() * k));
            p.setY((int) (p.getY() * k));
        }
    }

    /**
     * Applies an axial symmetry transformation to the polygon.
     *
     * @param axis the axis of symmetry to apply to the polygon
     */
    @Override
    public void applyAxialSymmetry(Axis axis) {
        for (Point p : this.points) {
            p.applyAxialSymmetry(axis);
        }
    }

    /**
     * Applies central symmetry to the polygon about the given point.
     *
     * @param p The point about which to apply central symmetry.
     */
    @Override
    public void applyCentralSymmetry(Point p) {
        for (Point p1 : this.points) {
            p1.applyCentralSymmetry(p);
        }
    }

    /**
     * Draws the polygon on the given graphics context.
     *
     * @param g The graphics context on which to draw the polygon.
     */
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

