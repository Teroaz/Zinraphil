package fr.zinraphil.models.geometry;

import fr.zinraphil.models.geometry.angle.Angle;

public class Point implements Comparable<Point> ,ITranslation ,Isymetriecentrale{

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
    public void symetriecentrale(Point p) {
        int x1= p.getX() + (p.getX() - this.x);
        int y1= p.getY() + (p.getY() - this.y);
        this.x=x1;
        this.y=y1;

    }
}








