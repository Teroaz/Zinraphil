package fr.zinraphil.models.geometry;

import fr.zinraphil.models.geometry.angle.Angle;
import fr.zinraphil.models.geometry.angle.AngleType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void rotation_symmetry() {
        Line line = new Line(new Point(125, 125), new Point(150, 125));
        line.applyRotation(new Angle(AngleType.DEGREE, 90));
        assertEquals(125, line.getP1().getX());
        assertEquals(125, line.getP1().getY());
        assertEquals(125, line.getP2().getX());
        assertEquals(100, line.getP2().getY());
    }

    @Test
    void translation_symmetry() {
        Line line = new Line(new Point(100, 125), new Point(125, 125));
        line.applyRotation(new Angle(AngleType.DEGREE, 90));
        assertEquals(100, line.getP1().getX());
        assertEquals(125, line.getP1().getY());
        assertEquals(100, line.getP2().getX());
        //assertEquals(100, line.getP2().getY());
    }
}
