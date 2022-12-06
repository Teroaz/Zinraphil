package fr.zinraphil.models.patchwork;

import fr.zinraphil.models.geometry.Shape;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Image {

    private int width;
    private int height;

    private final TreeSet<Shape> shapes = new TreeSet<>();

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
        // TODO: check if shape is in image
        System.out.println("Adding shape " + shape);
        shapes.add(shape);
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    public TreeSet<Shape> sortPerimeter() {
        return shapes.stream().sorted(Comparator.comparingDouble(Shape::perimeter)).collect(Collectors.toCollection(TreeSet::new));
    }

    public TreeSet<Shape> sortArea() {
        return shapes.stream().sorted(Comparator.comparingDouble(Shape::area)).collect(Collectors.toCollection(TreeSet::new));
    }

    @Override
    public String toString() {
        return "Image{" +
                "width=" + width +
                ", height=" + height +
                ", shapes=" + shapes +
                '}';
    }
}
