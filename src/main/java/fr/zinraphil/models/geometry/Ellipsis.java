package fr.zinraphil.models.geometry;

import fr.zinraphil.models.geometry.angle.Angle;
import fr.zinraphil.models.transformations.*;

import java.awt.*;

import static fr.zinraphil.models.geometry.angle.AngleType.DEGREE;

/**
 * Represents  Ellipsis in a two-dimensional plane.
 * It extends the {@link Shape} class and implements the
 * {@link IDrawable}, {@link ITranslation}, {@link IHomothethy},
 * and {@link ICentralSymmetry} interfaces.
 */
public class Ellipsis extends Shape<Ellipsis> implements IRotation, ITranslation, IHomothethy, ICentralSymmetry, IAxialSymmetry, IDrawable {

    /**
     * The center point of the ellipsis.
     */
    private final Point center;

    /**
     * The radius of the ellipsis along the x-axis.
     */
    private int radiusX;

    /**
     * The radius of the ellipsis along the y-axis.
     */
    private int radiusY;

    /**
     * The orientation of the ellipsis in the coordinate system.
     */
    private Angle azimuth = new Angle(DEGREE, 0);

    /**
     * Constructs a new ellipsis with the given center point and radii.
     *
     * @param center  the center point of the ellipsis
     * @param radiusX the radius of the ellipsis along the x-axis
     * @param radiusY the radius of the ellipsis along the y-axis
     * @throws IllegalArgumentException if radiusX and radiusY are equal
     */
    public Ellipsis(Point center, int radiusX, int radiusY) {
        this.center = center;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    /**
     * Constructs a new ellipsis with the given center point, radii, and azimuth angle.
     *
     * @param center  the center point of the ellipsis
     * @param radiusX the radius of the ellipsis along the x-axis
     * @param radiusY the radius of the ellipsis along the y-axis
     * @param azimuth the orientation of the ellipsis in the coordinate system
     * @throws IllegalArgumentException if radiusX and radiusY are equal
     */
    public Ellipsis(Point center, int radiusX, int radiusY, Angle azimuth) {
        this(center, radiusX, radiusY);
        this.azimuth = azimuth;
    }

    /**
     * Returns the center point of the ellipsis.
     *
     * @return the center point of the ellipsis
     */
    public Point getCenter() {
        return center;
    }

    /**
     * Returns the radius of the ellipsis along the x-axis.
     *
     * @return the radius of the ellipsis along the x-axis
     */
    public int getRadiusX() {
        return radiusX;
    }

    /**
     * Returns the radius of the ellipsis along the y-axis.
     *
     * @return the radius of the ellipsis along the y-axis
     */
    public int getRadiusY() {
        return radiusY;
    }

    /**
     * Returns the orientation of the ellipsis in the coordinate system.
     *
     * @return the orientation of the ellipsis in the coordinate system
     */
    public Angle getAzimuth() {
        return azimuth;
    }

    /**
     * Returns the area of the ellipsis.
     *
     * @return the area of the ellipsis
     */
    public double getArea() {
        return Math.PI * radiusX * radiusY;
    }

    /**
     * Returns the perimeter of the ellipsis.
     *
     * @return the perimeter of the ellipsis
     */
    public double getPerimeter() {
        return 2 * Math.PI * Math.sqrt((radiusX * radiusX + radiusY * radiusY) / 2);
    }

    /**
     * Compares this ellipsis to another shape.
     * <p>
     * The comparison is based on the class name, radiusX, radiusY, and azimuth angle of the ellipsis.
     *
     * @param o the shape to compare to
     * @return a negative integer, zero, or a positive integer as this shape is less than, equal to, or greater than the specified shape
     */
    @Override
    public int compareTo(Shape o) {
        if (this.getClass() != o.getClass()) return this.getClass().getName().compareTo(o.getClass().getName());

        Ellipsis e = (Ellipsis) o;
//        if (this.center.compareTo(e.getCenter()) != 0) return this.center.compareTo(e.getCenter());
        if (this.radiusX != e.getRadiusX()) return this.radiusX - e.getRadiusX();
        if (this.radiusY != e.getRadiusY()) return this.radiusY - e.getRadiusY();

        return this.azimuth.compareTo(e.getAzimuth());
    }

    /**
     * Draws the ellipsis on the given graphics object.
     *
     * @param g the graphics object to draw the ellipsis on
     */
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.rotate(azimuth.getRadian(), center.getX(), center.getY());
        g2d.drawOval(center.getX() - radiusX, center.getY() - radiusY, radiusX * 2, radiusY * 2);
        g2d.rotate(-azimuth.getRadian(), center.getX(), center.getY());
    }

    /**
     * Rotates the ellipsis by the given angle.
     *
     * @param angle the angle to rotate the ellipsis by
     */
    @Override
    public void applyRotation(Angle angle) {
        if (angle.getDegree() == 0) return;
        this.azimuth = this.azimuth.add(angle);
    }


    /**
     * Translates the ellipsis by the given delta values along the x and y axes.
     *
     * @param deltaX the value to translate the ellipsis along the x-axis
     * @param deltaY the value to translate the ellipsis along the y-axis
     */
    @Override
    public void applyTranslation(int deltaX, int deltaY) {
        this.center.applyTranslation(deltaX, deltaY);
    }

    /**
     * Applies a homothety transformation to the ellipsis with the given scale factor.
     *
     * @param k the scale factor for the homothety transformation
     */
    @Override
    public void applyHomothety(float k) {
        this.radiusX *= k;
        this.radiusY *= k;
    }

    /**
     * Returns central symmetry transformation to the ellipsis with respect to the given point.
     *
     * @param p the point to reflect the ellipsis over
     */
    @Override
    public void applyCentralSymmetry(Point p) {
        this.center.applyCentralSymmetry(p);
        this.applyRotation(new Angle(DEGREE, 180));

    }

    @Override
    public String toString() {
        return "Ellipsis{" +
                "center=" + center +
                ", radiusX=" + radiusX +
                ", radiusY=" + radiusY +
                ", azimuth=" + azimuth +
                '}';
    }

    /**
     * Applies an axial symmetry transformation to the ellipsis with respect to the given axis.
     *
     * @param axis the axis to reflect the ellipsis over
     */
    @Override
    public void applyAxialSymmetry(Axis axis) {
        this.center.applyAxialSymmetry(axis);
        if (axis == Axis.X) {
            this.azimuth = this.azimuth.add(new Angle(DEGREE, this.azimuth.getDegree() * 2));
        } else {
            this.azimuth = this.azimuth.add(new Angle(DEGREE, (180 - this.azimuth.getDegree() * 2)));
        }
    }
}
