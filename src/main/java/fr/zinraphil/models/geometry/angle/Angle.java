package fr.zinraphil.models.geometry.angle;

/**
 * A class representing an angle. Implementing Comparable, it can be used in a TreeSet.
 */
public class Angle implements Comparable<Angle> {
    /**
     * The type of the angle.
     */
    private AngleType type;

    /**
     * The value of the angle.
     */
    private int value;

    /**
     * Creates a new angle with the specified type and value.
     *
     * @param type  The type of the angle (radians or degrees).
     * @param value The value of the angle.
     */
    public Angle(AngleType type, int value) {
        this.type = type;
        this.value = value;
    }

    /**
     * Returns the value of the angle in radians.
     *
     * @return The value of the angle in radians.
     */
    public int getRadian() {
        if (type == AngleType.RADIAN) return value;
        return (int) Math.toRadians(value);
    }

    /**
     * Returns the value of the angle in degrees.
     *
     * @return The value of the angle in degrees.
     */
    public int getDegree() {
        if (type == AngleType.DEGREE) return value;
        return (int) Math.toDegrees(value);
    }

    /**
     * Compares this angle to the specified angle.
     *
     * @param o The angle to compare to.
     * @return A negative integer, zero, or a positive integer as this angle is
     * less than, equal to, or greater than the specified angle.
     */
    @Override
    public int compareTo(Angle o) {
        return this.getRadian() - o.getRadian();
    }

    /**
     * Returns a new angle that is the sum of this angle and the specified angle.
     *
     * @param angle The angle to add to this angle.
     * @return A new angle that is the sum of this angle and the specified angle.
     */
    public Angle add(Angle angle) {
        return new Angle(AngleType.RADIAN, this.getRadian() + angle.getRadian());
    }

    /**
     * Prints the information of this angle.
     *
     * @return The information of this angle.
     */
    @Override
    public String toString() {
        return "Angle{" +
                "value=" + value +
                ", type=" + type +
                '}';
    }
}
