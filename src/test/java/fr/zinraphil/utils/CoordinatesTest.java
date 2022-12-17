package fr.zinraphil.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {


    @Test
    void transformCoordinates() {
        Coordinates coordinates = new Coordinates();
        assertEquals(0, coordinates.transformCoordinates(125));
        assertEquals(-25, coordinates.transformCoordinates(100));
        assertEquals(25, coordinates.transformCoordinates(150));
        assertEquals(-50, coordinates.transformCoordinates(75));
        assertEquals(125, coordinates.transformCoordinates(250));
    }

    @Test
    void revertCoordinates() {
        Coordinates coordinates = new Coordinates();
        assertEquals(125, coordinates.revertCoordinates(0));
        assertEquals(100, coordinates.revertCoordinates(-25));
        assertEquals(150, coordinates.revertCoordinates(25));
        assertEquals(75, coordinates.revertCoordinates(-50));
        assertEquals(250, coordinates.revertCoordinates(125));
    }
}