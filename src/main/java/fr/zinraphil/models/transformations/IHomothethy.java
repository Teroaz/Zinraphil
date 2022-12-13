package fr.zinraphil.models.transformations;

/**
 * Interface for objects that can be transformed by homothety.
 */
public interface IHomothethy {

    /**
     * Applies homothety to the object with the specified scale factor.
     *
     * @param k the scale factor
     */
    void applyHomothety(float k);
}
