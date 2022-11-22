package fr.zinraphil.models.geometry.angle;


public class Angle implements Comparable<Angle> {

    private int value;
    private AngleType type;

    public Angle(AngleType type, int value) {
        this.type = type;
        this.value = value;
    }

    public int getRadian() {
        if (type == AngleType.RADIAN) return value;
        return (int) Math.toRadians(value);
    }

    public int getDegree() {
        if (type == AngleType.DEGREE) return value;
        return (int) Math.toDegrees(value);
    }

    @Override
    public int compareTo(Angle o) {
        return this.getRadian() - o.getRadian();
    }
}
