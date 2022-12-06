package fr.zinraphil.models.geometry;

public abstract class Shape<T extends Shape<T>> implements Comparable<Shape> {

    abstract public double area();

    abstract public double perimeter();


}
