package fr.zinraphil.models.transformations;

/**
 * Interface for objects that can be translated.
 */
public interface ITranslation {

    /**
     * Applies translation to the object with the specified offsets in the X and Y directions.
     *
     * @param deltaX the offset in the X direction
     * @param deltaY the offset in the Y direction
     */
    void applyTranslation(int deltaX, int deltaY);
}
