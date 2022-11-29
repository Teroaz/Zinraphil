package fr.zinraphil.models.geometry;

import fr.zinraphil.models.geometry.angle.Angle;
import fr.zinraphil.models.transformations.axial_symetry.AxialSymmetryShape;
import fr.zinraphil.models.transformations.axial_symetry.Axis;

import java.util.ArrayList;

import static java.lang.Math.cos;

public class Polygon extends Shape<Polygon> implements AxialSymmetryShape, IRotation, ITranslation ,Isymetrieaxiale,Isymetriecentrale{

    private ArrayList<Point> points;

    public Polygon(ArrayList<Point> points) {
        this.points = points;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public double area() {
        // Calculate the are of a polygon using the Shoelace formula
        // https://en.wikipedia.org/wiki/Shoelace_formula
        double area = 0;
        for (int i = 0; i < points.size(); i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % points.size());
            area += p1.getX() * p2.getY() - p2.getX() * p1.getY();
        }
        return Math.abs(area) / 2;
    }

    public double perimeter() {
        double perimeter = 0;
        for (int i = 0; i < points.size(); i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % points.size());
            perimeter += Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
        }
        return perimeter;
    }

    @Override
    public int compareTo(Polygon o) {

        int samePoints = 0;
        if (this.points.size() != o.getPoints().size()) return this.points.size() - o.getPoints().size();
        for (Point p : this.points) {
            for (Point p2 : o.getPoints()) {
                if (p.compareTo(p2) == 0) samePoints++;
            }
        }

        return samePoints - this.points.size();
    }

    @Override
    public void applyAxialSymmetry(Axis axis) {
        for (Point p : this.points) {
            if (axis == Axis.X) {
                p.setY(-p.getY());
            } else if (axis == Axis.Y) {
                p.setX(-p.getX());
            }
        }
    }

    @Override
    public void rotation(Angle angle) {
        for (int i = 0; i < points.size(); i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % points.size());

            p2.setX((int) (p2.getX() * cos(angle.getDegree())));
            p2.setY((int) (p2.getY() * cos(angle.getDegree())));


        }
    }

    @Override
    public void translation(int deltaX, int deltaY) {
        for (Point p : this.points) {
            p.translation(deltaX, deltaY);
        }
    }

    @Override
    public void symetrieaxiale() {
        for (Point p : this.points) {
            p.setX(-p.getX());
            p.setY(-p.getY());
        }
    }

    @Override
    public void symetriecentrale() {
        for (Point p : this.points) {
            p.setX(-p.getX());
            p.setY(-p.getY());
        }
    }
}


