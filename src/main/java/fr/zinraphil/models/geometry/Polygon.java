package fr.zinraphil.models.geometry;

import fr.zinraphil.models.transformations.axial_symetry.AxialSymmetryShape;
import fr.zinraphil.models.transformations.axial_symetry.Axis;

import java.util.ArrayList;

public class Polygon extends Shape<Polygon> implements AxialSymmetryShape {

    private ArrayList<Point> points;

    public Polygon(ArrayList<Point> points) {
        this.points = points;
    }

    public ArrayList<Point> getPoints() {
        return points;
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
}
