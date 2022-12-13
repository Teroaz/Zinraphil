package fr.zinraphil.models.transformations;

import fr.zinraphil.models.geometry.Point;

/**
 * Interface for objects that can be symmetrical about a central point.
 */
public interface ICentralSymmetry {

    /**
     * Applies central symmetry to the object about the specified point.
     *
     * @param p the central point about which to apply the symmetry
     */
    void applyCentralSymmetry(Point p);
}
