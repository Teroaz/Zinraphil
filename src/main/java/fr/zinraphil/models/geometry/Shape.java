package fr.zinraphil.models.geometry;

public abstract class Shape<T extends Shape<T>> implements Comparable<T> {

    abstract public double area();

    abstract public double perimeter();


}
