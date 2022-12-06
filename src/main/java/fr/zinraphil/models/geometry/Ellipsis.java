package fr.zinraphil.models.geometry;

import fr.zinraphil.models.geometry.angle.Angle;
import fr.zinraphil.models.transformations.axial_symetry.AxialSymmetryShape;
import fr.zinraphil.models.transformations.axial_symetry.Axis;

import java.awt.*;

import static fr.zinraphil.models.geometry.angle.AngleType.DEGREE;

public class Ellipsis extends Shape<Ellipsis> implements AxialSymmetryShape, IDrawable, IRotation, ITranslation, Isymetrieaxiale, Isymetriecentrale {

    private final Point center;
    private final int radiusX;
    private final int radiusY;

    private Angle azimuth = new Angle(DEGREE, 0);

    public Ellipsis(Point center, int radiusX, int radiusY) {
        if (radiusX==radiusY){
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
    public void draw(Graphics g) {
        g.drawOval(center.getX() - radiusX, center.getY() - radiusY, radiusX * 2, radiusY * 2);
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
    public void symetrieaxiale() {



    }

    @Override
    public void symetriecentrale() {


    }
}
