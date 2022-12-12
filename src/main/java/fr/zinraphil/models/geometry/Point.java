package fr.zinraphil.models.geometry;

import fr.zinraphil.models.transformations.Axis;
import fr.zinraphil.models.transformations.IAxialSymmetry;
import fr.zinraphil.models.transformations.ICentralSymmetry;
import fr.zinraphil.models.transformations.ITranslation;

import static fr.zinraphil.controllers.ZinraphilController.IMAGE_SIZE;

public class Point implements Comparable<Point>, ITranslation, IAxialSymmetry, ICentralSymmetry {

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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    @Override
    public int compareTo(Point o) {
        if (this.x != o.getX()) return this.x - o.getX();
        return this.y - o.getY();
    }

    public void applyTranslation(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    @Override
    public void applyCentralSymmetry(Point p) {
        int x1 = p.getX() + (p.getX() - this.x);
        int y1 = p.getY() + (p.getY() - this.y);
        this.x = x1;
        this.y = y1;
    }

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
