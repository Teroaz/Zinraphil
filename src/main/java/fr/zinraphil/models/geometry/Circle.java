package fr.zinraphil.models.geometry;

import fr.zinraphil.models.transformations.*;

import java.awt.*;

/**
 * Represents a circle in a two-dimensional plane.
 * It extends the {@link Shape} class and implements the
 * {@link IDrawable}, {@link ITranslation}, {@link IHomothethy},
 * and {@link ICentralSymmetry} interfaces.
 */
public class Circle extends Shape<Circle> implements IDrawable, ITranslation, IHomothethy, ICentralSymmetry, IAxialSymmetry {

    /**
     * The center of this circle.
     */
    private Point center;

    /**
     * The radius of this circle.
     */
    private int radius;

    /**
     * Constructs a new Circle with the specified center and radius.
     *
     * @param center the center of this circle
     * @param radius the radius of this circle
     */
    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    /**
     * Returns the center of this circle.
     *
     * @return the center of this circle
     */
    public Point getCenter() {
        return center;
    }

    /**
     * Returns the radius of this circle.
     *
     * @return the radius of this circle
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Returns the area of this circle.
     *
     * @return the area of this circle
     */
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Returns the perimeter of this circle.
     *
     * @return the perimeter of this circle
     */
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * Compares this circle to the specified shape. The result is a
     * negative integer if this circle is "less than" the specified
     * shape, zero if this circle is "equal to" the specified shape,
     * and a positive integer if this circle is "greater than" the
     * specified shape.
     *
     * @param
     */
    @Override
    public int compareTo(Shape o) {
        if (this.getClass() != o.getClass()) return this.getClass().getName().compareTo(o.getClass().getName());

        Circle c = (Circle) o;
//        if (this.center.compareTo(c.getCenter()) != 0) return this.center.compareTo(c.getCenter());
        return this.radius - c.getRadius();
    }

    /**
     * Translates the center of the circle by the specified amounts.
     *
     * @param deltaX the amount to translate the x-coordinate of the center.
     * @param deltaY the amount to translate the y-coordinate of the center.
     */
    public void applyTranslation(int deltaX, int deltaY) {
        this.center.applyTranslation(deltaX, deltaY);
    }

    /**
     * Draws the circle onto the specified graphics object.
     *
     * @param g the graphics object to draw the circle onto.
     */
    @Override
    public void draw(Graphics g) {
        g.drawOval(center.getX() - radius, center.getY() - radius, radius * 2, radius * 2);
    }

    /**
     * Applies a homothety transformation to the circle.
     *
     * @param k the scale factor of the transformation.
     */
    @Override
    public void applyHomothety(float k) {
        this.radius *= k;
    }

    /**
     * Applies a central symmetry transformation to the circle.
     *
     * @param p the center point of the symmetry.
     */
    @Override
    public void applyCentralSymmetry(Point p) {
        this.center.applyCentralSymmetry(p);
    }

    /**
     * Returns a string representation of the circle.
     *
     * @return a string of the form "Circle{center=(x, y), radius=r}"
     */
    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }

    /**
     * Applies an axial symmetry transformation of the axis.
     *
     * @param axis the axis along which to apply the symmetry
     */
    @Override
    public void applyAxialSymmetry(Axis axis) {
        this.center.applyAxialSymmetry(axis);
    }
}
