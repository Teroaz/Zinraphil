package fr.zinraphil.models.patchwork;

import fr.zinraphil.models.geometry.Shape;

import java.util.TreeSet;

public class Image {

    private int width;
    private int height;

    private TreeSet<Shape> shapes = new TreeSet<>();

    public Image(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public TreeSet<Shape> getShapes() {
        return shapes;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }
}
