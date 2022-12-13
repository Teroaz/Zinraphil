package fr.zinraphil.utils;

import static fr.zinraphil.controllers.ZinraphilController.IMAGE_SIZE;

public class Coordinates {

    private final int width = IMAGE_SIZE / 2;

    public int transformCoordinates(int x) {
        return x - this.width;
    }


    public int revertCoordinates(int x) {
        return x + this.width;
    }


}
