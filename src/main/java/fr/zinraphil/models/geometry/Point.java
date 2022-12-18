package fr.zinraphil.models.geometry;

import fr.zinraphil.models.transformations.Axis;
import fr.zinraphil.models.transformations.IAxialSymmetry;
import fr.zinraphil.models.transformations.ICentralSymmetry;
import fr.zinraphil.models.transformations.ITranslation;
import fr.zinraphil.utils.Coordinates;

import static fr.zinraphil.controllers.ZinraphilController.IMAGE_SIZE;

/**
 * Represents a point on a two-dimensional plane.
 */
public class Point implements Comparable<Point>, ITranslation, IAxialSymmetry, ICentralSymmetry {

    // Instance variables for the x and y coordinates of the point.
    private int x;
    private int y;

    /**
     * Constructs a new Point object with the given x and y coordinates.
     *
     * @param x the x coordinate of the point
     * @param y the y coordinate of the point
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x coordinate of the point.
     *
     * @return the x coordinate of the point
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y coordinate of the point.
     *
     * @return the y coordinate of the point
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the x coordinate of the point.
     *
     * @param x the new x coordinate of the point
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the y coordinate of the point.
     *
     * @param y the new y coordinate of the point
     */
    public void setY(int y) {
        this.y = y;
    }


    /**
     * Compares this point to another point. The comparison is based on the x coordinates, then the y coordinates.
     *
     * @param o the other point to compare to
     * @return a negative integer, zero, or a positive integer as this point is less than, equal to, or greater than the other point
     */
    @Override
    public int compareTo(Point o) {
        if (this.x != o.getX()) return this.x - o.getX();
        return this.y - o.getY();
    }

    /**
     * Applies a translation to the point by adding the given amounts to its x and y coordinates.
     *
     * @param deltaX the amount to translate in the x direction
     * @param deltaY the amount to translate in the y direction
     */
    public void applyTranslation(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    /**
     * Applies a central symmetry to the point by reflecting it across the given point.
     *
     * @param p the point of symmetry
     */
    @Override
    public void applyCentralSymmetry(Point p) {
        Coordinates coordinates = new Coordinates();
        int x1 = coordinates.transformCoordinates(this.x);
        int y1 = coordinates.transformCoordinates(this.y);

        int pX = p.getX();
        int pY = p.getY();

        int x2 = pX + (pX - x1);
        int y2 = pY + (pY - y1);

        this.x = coordinates.revertCoordinates(x2);
        this.y = coordinates.revertCoordinates(y2);
    }

    /**
     * Applies an axial symmetry to the point by reflecting it across the given axis.
     *
     * @param axis the axis of symmetry
     */
    @Override
    public void applyAxialSymmetry(Axis axis) {
        if (axis == Axis.X) {
            this.y = IMAGE_SIZE - this.y;
        } else {
            this.x = IMAGE_SIZE - this.x;
        }
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}
