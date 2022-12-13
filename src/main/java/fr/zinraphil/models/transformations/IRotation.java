package fr.zinraphil.models.transformations;

import fr.zinraphil.models.geometry.angle.Angle;

/**
 * Interface for objects that can be rotated.
 */
public interface IRotation {

    /**
     * Applies rotation to the object with the specified angle.
     *
     * @param angle the angle of rotation
     */
    void applyRotation(Angle angle);
}
