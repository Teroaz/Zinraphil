package fr.zinraphil.models.patchwork;

import fr.zinraphil.models.geometry.Point;

import java.util.HashMap;

public class Fresco {
    private HashMap<Point, Image> images = new HashMap<>();

    public Fresco() {
    }

    public HashMap<Point, Image> getImages() {
        return images;
    }

    public void addImage(Point point, Image image) {
        images.put(point, image);
    }

}
