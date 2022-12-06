package fr.zinraphil.models.geometry;

import fr.zinraphil.models.geometry.angle.Angle;
import fr.zinraphil.models.transformations.axial_symetry.AxialSymmetryShape;
import fr.zinraphil.models.transformations.axial_symetry.Axis;

import static fr.zinraphil.models.geometry.angle.AngleType.DEGREE;

public class Ellipsis extends Shape<Ellipsis> implements AxialSymmetryShape, IRotation, ITranslation, Ihomothety ,Isymetriecentrale{

    private final Point center;
    private int radiusX;
    private int radiusY;

    private Angle azimuth = new Angle(DEGREE, 0);

    public Ellipsis(Point center, int radiusX, int radiusY) {
        if (radiusX == radiusY) {
            throw new IllegalArgumentException("The radiusX and radiusY must be different");
        }
        this.center = center;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    public Ellipsis(Point center, int radiusX, int radiusY, Angle azimuth) {
        this(center, radiusX, radiusY);
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

    public double area() {
        return Math.PI * radiusX * radiusY;
    }

    public double perimeter() {
        return 2 * Math.PI * Math.sqrt((radiusX * radiusX + radiusY * radiusY) / 2);
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

    @Override
    public void rotation(Angle angle) {
        if (angle.getDegree() == 0) return;
        this.azimuth = this.azimuth.add(angle);
    }


    @Override
    public void translation(int deltaX, int deltaY) {
        this.center.translation(deltaX, deltaY);
    }

    @Override
    public void homothety(float k) {
        this.radiusX *= k;
        this.radiusY *= k;
    }

    @Override
    public void symetriecentrale(Point p) {
        int x1= p.getX() + (p.getX() - center.getX());
        int y1= p.getY() + (p.getY() - center.getY());
        this.center.setX(x1);
        this.center.setY(y1);

    }
}
