package fr.zinraphil.models.patchwork;

import fr.zinraphil.models.geometry.Point;

import java.util.HashMap;

/**
 * Fresco is a class that maintains a collection of images and their corresponding locations.
 */
public class Fresco {
    // A map that stores the images and their locations.
    private final HashMap<Point, Image> images = new HashMap<>();

    /**
     * Constructs a new Fresco object.
     */
    public Fresco() {
    }

    /**
     * Returns the map of images and their locations.
     *
     * @return the map of images and their locations
     */
    public HashMap<Point, Image> getImages() {
        return images;
    }

    /**
     * Adds an image to the collection at the specified location.
     *
     * @param point the location at which to add the image
     * @param image the image to add
     */
    public void addImage(Point point, Image image) {
        images.put(point, image);
    }

    /**
     * Calculates the total area of the fresco.
     *
     * @return the total area of the fresco
     */
    public double getArea() {
        return images.values().stream().mapToDouble(Image::getArea).sum();
    }

    /**
     * Calculates the total perimeter of the fresco.
     *
     * @return the total perimeter of the fresco
     */
    public double getPerimeter() {
        return images.values().stream().mapToDouble(Image::getPerimeter).sum();
    }

    /**
     * Returns a string representation of the fresco.
     *
     * @return a string representation of the fresco
     */
    @Override
    public String toString() {
        return "Fresco{" +
                "images=" + images +
                '}';
    }
}
