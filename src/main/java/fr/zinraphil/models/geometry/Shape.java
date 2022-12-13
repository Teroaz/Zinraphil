package fr.zinraphil.models.geometry;

/**
 * Represents a shape in a two-dimensional plane.
 *
 * @param <T> The type of the shape that the class represents.
 */
public abstract class Shape<T extends Shape<T>> implements Comparable<Shape> {

    /**
     * Returns the area of the shape.
     *
     * @return The area of the shape.
     */
    abstract public double getArea();

    /**
     * Returns the perimeter of the shape.
     *
     * @return The perimeter of the shape.
     */
    abstract public double getPerimeter();


}
