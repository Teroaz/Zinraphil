package fr.zinraphil.models.transformations;

/**
 * Interface for objects that can be symmetrical along an axis.
 */
public interface IAxialSymmetry {

    /**
     * Applies axial symmetry to the object along the specified axis.
     *
     * @param axis the axis along which to apply the symmetry
     */
    void applyAxialSymmetry(Axis axis);
}