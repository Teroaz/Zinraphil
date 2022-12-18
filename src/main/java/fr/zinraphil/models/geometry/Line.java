package fr.zinraphil.models.geometry;

import fr.zinraphil.models.geometry.angle.Angle;
import fr.zinraphil.models.transformations.*;
import fr.zinraphil.utils.Coordinates;

import java.awt.*;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * Represents a line in a two-dimensional plane.
 * It extends the {@link Shape} class and implements the
 * {@link IDrawable}, {@link IRotation}, {@link ITranslation}, {@link IHomothethy},
 * {@link IAxialSymmetry} and {@link ICentralSymmetry} interfaces.
 */
public class Line extends Shape<Line> implements IDrawable, IRotation, ITranslation, ICentralSymmetry, IHomothethy, IAxialSymmetry {

    // Instance variables for the start and end points of the line.
    private Point p1;
    private Point p2;

    /**
     * Creates a new line with the given end points.
     *
     * @param p1 the first end point of the line
     * @param p2 the second end point of the line
     */
    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * Returns the first end point of the line.
     *
     * @return the first end point of the line
     */
    public Point getP1() {
        return p1;
    }

    /**
     * Returns the second end point of the line.
     *
     * @return the second end point of the line
     */
    public Point getP2() {
        return p2;
    }

    /**
     * Returns the length of the line.
     *
     * @return the length of the line
     */
    public double length() {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }

    /**
     * Returns the area of the line.
     *
     * @return the area of the line
     */
    public double getArea() {
        return 0;
    }

    /**
     * Returns the perimeter of the line.
     *
     * @return the perimeter of the line
     */
    public double getPerimeter() {
        return length();
    }


    /**
     * Compares this line to another shape. If the other shape is not a line, the comparison is based on the class names.
     * If the other shape is a line, the comparison is based on the start points, then the end points.
     *
     * @param o the other shape to compare to
     * @return a negative integer, zero, or a positive integer as this line is less than, equal to, or greater than the other shape
     */
    @Override
    public int compareTo(Shape o) {
        if (this.getClass() != o.getClass()) return this.getClass().getName().compareTo(o.getClass().getName());

        Line l = (Line) o;
        if (this.p1.compareTo(l.getP1()) != 0) return this.p1.compareTo(l.getP1());
        return this.p2.compareTo(l.getP2());
    }

    /**
     * Applies a translation to the line by applying the translation to each of its end points.
     *
     * @param deltaX the amount to translate in the x direction
     * @param deltaY the amount to translate in the y direction
     */
    public void applyTranslation(int deltaX, int deltaY) {
        p1.applyTranslation(deltaX, deltaY);
        p2.applyTranslation(deltaX, deltaY);
    }


    /**
     * Applies a rotation to the line by rotating its end point around the start point.
     *
     * @param angle the angle of rotation
     */
    @Override
    public void applyRotation(Angle angle) {
        Coordinates coordinates = new Coordinates();

        int centerX = coordinates.transformCoordinates(this.p1.getX());
        int centerY = coordinates.transformCoordinates(this.p1.getY());

        int point2x = coordinates.transformCoordinates(this.p2.getX());
        int point2y = coordinates.transformCoordinates(this.p2.getY());

        double x = angle.getRadian();

        double newX = Math.cos(x) * (point2x - centerX) - Math.sin(x) * (point2y - centerY) + centerX;
        double newY = Math.sin(x) * (point2x - centerX) + Math.cos(x) * (point2y - centerY) + centerY;

        p2.setX(coordinates.revertCoordinates((int) newX));
        p2.setY(coordinates.revertCoordinates((int) newY));
    }

    /**
     * Applies a homothety to the line by scaling its end points.
     *
     * @param k the scaling factor
     */
    @Override
    public void applyHomothety(float k) {
        p1.setX((int) (p1.getX() * k));
        p2.setX((int) (p2.getX() * k));
        p1.setY((int) (p1.getY() * k));
        p2.setY((int) (p2.getY() * k));
    }

    /**
     * Applies an axial symmetry to the line by reflecting its end points across the given axis.
     *
     * @param axis the axis of symmetry
     */
    @Override
    public void applyAxialSymmetry(Axis axis) {
        this.p1.applyAxialSymmetry(axis);
        this.p2.applyAxialSymmetry(axis);
    }

    /**
     * Applies a central symmetry to the line by reflecting its end points across the given point.
     *
     * @param p the point of symmetry
     */
    @Override
    public void applyCentralSymmetry(Point p) {
        int x1 = p.getX() + (p.getX() - p1.getX());
        int y1 = p.getY() + (p.getY() - p1.getY());
        int x2 = p.getX() + (p.getX() - p2.getX());
        int y2 = p.getY() + (p.getY() - p2.getY());
        p1.setX(x1);
        p1.setY(y1);
        p2.setX(x2);
        p2.setY(y2);
    }

    /**
     * Draws the line on the given graphics context.
     *
     * @param g the graphics context on which to draw the line
     */
    @Override
    public void draw(Graphics g) {
        g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
}

