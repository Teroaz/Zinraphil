package fr.zinraphil.models.geometry;

import fr.zinraphil.models.transformations.axial_symetry.Axis;

import static fr.zinraphil.controllers.ZinraphilController.IMAGE_SIZE;

public class Point implements Comparable<Point> ,ITranslation ,Isymetrieaxiale{

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    @Override
    public int compareTo(Point o) {
        if (this.x != o.getX()) return this.x - o.getX();
        return this.y - o.getY();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void translation(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    @Override
    public void symetrieaxiale(Axis axis) {
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


