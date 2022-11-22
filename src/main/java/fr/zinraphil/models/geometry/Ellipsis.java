package fr.zinraphil.models.geometry;

import fr.zinraphil.models.geometry.angle.Angle;
import fr.zinraphil.models.transformations.axial_symetry.AxialSymmetryShape;
import fr.zinraphil.models.transformations.axial_symetry.Axis;

import static fr.zinraphil.models.geometry.angle.AngleType.DEGREE;

public class Ellipsis extends Shape<Ellipsis> implements AxialSymmetryShape {

    private final Point center;
    private final int radiusX;
    private final int radiusY;

    private Angle azimuth = new Angle(DEGREE, 0);

    public Ellipsis(Point center, int radiusX, int radiusY) {
        this.center = center;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    public Ellipsis(Point center, int radiusX, int radiusY, Angle azimuth) {
        this.center = center;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
        this.azimuth = azimuth;
    }

    public Point getCenter() {
        return center;
    }

    public int getRadiusX() {
        return radiusX;
    }

    public int getRadiusY() {
        return radiusY;
    }

    public Angle getAzimuth() {
        return azimuth;
    }

    @Override
    public int compareTo(Ellipsis o) {
        if (this.center.compareTo(o.getCenter()) != 0) return this.center.compareTo(o.getCenter());
        if (this.radiusX != o.getRadiusX()) return this.radiusX - o.getRadiusX();
        if (this.radiusY != o.getRadiusY()) return this.radiusY - o.getRadiusY();

        return this.azimuth.compareTo(o.getAzimuth());
    }

    @Override
    public void applyAxialSymmetry(Axis axis) {

    }
}
