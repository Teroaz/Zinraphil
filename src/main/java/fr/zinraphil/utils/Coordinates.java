package fr.zinraphil.utils;

import static fr.zinraphil.controllers.ZinraphilController.IMAGE_SIZE;

/**
 * Coordinates is a class that provides methods for transforming and reverting coordinates.
 */
public class Coordinates {
    // The width of the image, used for transforming and reverting coordinates.
    private final int width = IMAGE_SIZE / 2;

    /**
     * Transforms the given x coordinate by subtracting the width of the image from it.
     *
     * @param x the x coordinate to transform
     * @return the transformed x coordinate
     */
    public int transformCoordinates(int x) {
        return x - this.width;
    }

    /**
     * Reverts the given x coordinate by adding the width of the image to it.
     *
     * @param x the x coordinate to revert
     * @return the reverted x coordinate
     */
    public int revertCoordinates(int x) {
        return x + this.width;
    }
}
