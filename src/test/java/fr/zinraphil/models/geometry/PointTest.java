package fr.zinraphil.models.geometry;

import fr.zinraphil.models.transformations.axial_symetry.Axis;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @org.junit.jupiter.api.Test
    void compareTo() {
        Point point = new Point(1, 2);
        Point point2 = new Point(1, 2);
        assertEquals(0, point.compareTo(point2));
    }

    @org.junit.jupiter.api.Test
    void translation() {
        Point point = new Point(1, 2);
        point.translation(1, 1);
        assertEquals(2, point.getX());
        assertEquals(3, point.getY());
    }

    @org.junit.jupiter.api.Test
    void symetrieaxialeX() {
        Point point = new Point(1, 2);
        point.symetrieaxiale(Axis.X);
        assertEquals(1, point.getX());
        assertEquals(248, point.getY());
    }

    @org.junit.jupiter.api.Test
    void symetrieaxialeY() {
        Point point = new Point(1, 2);
        point.symetrieaxiale(Axis.Y);
        assertEquals(249, point.getX());
        assertEquals(2, point.getY());
    }
}
