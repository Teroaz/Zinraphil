package fr.zinraphil.models.geometry;

import fr.zinraphil.models.geometry.angle.Angle;
import fr.zinraphil.models.geometry.angle.AngleType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PolygonTest {

    ArrayList<Point> getTestPoints() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(-1, -3));
        points.add(new Point(-3, -1));
        points.add(new Point(1, 3));
        points.add(new Point(-1, 3));
        points.add(new Point(1, 5));
        points.add(new Point(3, 3));
        points.add(new Point(1, 1));
        points.add(new Point(3, -1));
        points.add(new Point(1, -1));
        return points;
    }

    ArrayList<Point> getSquarePoints() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(50, 50));
        points.add(new Point(100, 50));
        points.add(new Point(100, 100));
        points.add(new Point(50, 100));
        return points;
    }

    @org.junit.jupiter.api.Test
    void area() {

        ArrayList<Point> points = getTestPoints();
        Polygon polygon = new Polygon(points);
        assertEquals(20, polygon.area());
    }

    @org.junit.jupiter.api.Test
    void perimeter() {
        ArrayList<Point> points = getTestPoints();
        Polygon polygon = new Polygon(points);
        assertEquals(4, polygon.perimeter());
    }

    @org.junit.jupiter.api.Test
    void compareTo() {
        ArrayList<Point> points = getTestPoints();
        Polygon polygon = new Polygon(points);
        Polygon polygon2 = new Polygon(points);
        assertEquals(0, polygon.compareTo(polygon2));
    }

    @Test
    void rotation() {
        ArrayList<Point> points = getSquarePoints();
        Polygon polygon = new Polygon(points);
        Angle angle = new Angle(AngleType.DEGREE, 90);
        polygon.rotation(angle);
        assertEquals(100, polygon.getPoints().get(0).getX());
        assertEquals(50, polygon.getPoints().get(0).getY());
        assertEquals(100, polygon.getPoints().get(1).getX());
        assertEquals(100, polygon.getPoints().get(1).getY());
        assertEquals(50, polygon.getPoints().get(2).getX());
        assertEquals(100, polygon.getPoints().get(2).getY());
        assertEquals(50, polygon.getPoints().get(3).getX());
        assertEquals(50, polygon.getPoints().get(3).getY());
    }

    @Test
    void translation() {
    }

    @Test
    void symetrieaxiale() {
    }
}
