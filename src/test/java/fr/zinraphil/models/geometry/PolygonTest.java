package fr.zinraphil.models.geometry;

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
}
