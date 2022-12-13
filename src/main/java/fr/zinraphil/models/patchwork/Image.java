package fr.zinraphil.models.patchwork;

import fr.zinraphil.models.geometry.Shape;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * This class represents an image.
 * <p>
 * It has a width, a height, and a set of shapes.
 * <p>
 * The set of shapes is sorted according to the perimeter or area of the shapes.
 */
public class Image {
    private int width;
    private int height;

    private final TreeSet<Shape> shapes = new TreeSet<>();

    /**
     * Constructs a new Image with the given width and height.
     *
     * @param width  the width of the image
     * @param height the height of the image
     */
    public Image(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Returns the width of the image.
     *
     * @return the width of the image
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height of the image.
     *
     * @return the height of the image
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns the set of shapes contained in the image.
     *
     * @return the set of shapes contained in the image
     */
    public TreeSet<Shape> getShapes() {
        return shapes;
    }

    /**
     * Adds a shape to the set of shapes contained in the image.
     *
     * @param shape the shape to add to the set of shapes
     * @return true if the shape was added to the set of shapes, false otherwise
     */
    public boolean addShape(Shape shape) {
        return shapes.add(shape);
    }

    /**
     * Sorts the shapes in the image by perimeter in ascending order.
     *
     * @return a new TreeSet containing the sorted shapes
     */
    public TreeSet<Shape> sortPerimeter() {
        return shapes.stream().sorted(Comparator.comparingDouble(Shape::getPerimeter)).collect(Collectors.toCollection(TreeSet::new));
    }

    /**
     * Sorts the shapes in the image by area in ascending order.
     *
     * @return a new TreeSet containing the sorted shapes
     */
    public TreeSet<Shape> sortArea() {
        return shapes.stream().sorted(Comparator.comparingDouble(Shape::getArea)).collect(Collectors.toCollection(TreeSet::new));
    }

    /**
     * Returns a string representation of the image.
     *
     * @return a string representation of the image
     */
    @Override
    public String toString() {
        return "Image{" +
                "width=" + width +
                ", height=" + height +
                ", shapes=" + shapes +
                '}';
    }
}
