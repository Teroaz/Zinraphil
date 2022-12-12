package fr.zinraphil.models.geometry;

import fr.zinraphil.models.geometry.angle.Angle;
import fr.zinraphil.models.transformations.*;

import java.awt.*;

import static fr.zinraphil.controllers.ZinraphilController.IMAGE_SIZE;
import static fr.zinraphil.models.geometry.angle.AngleType.DEGREE;

public class Ellipsis extends Shape<Ellipsis> implements IRotation, ITranslation, IHomothethy, ICentralSymmetry, IDrawable {

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

    public double getArea() {
        return Math.PI * radiusX * radiusY;
    }

    public double getPerimeter() {
        return 2 * Math.PI * Math.sqrt((radiusX * radiusX + radiusY * radiusY) / 2);
    }

    @Override
    public int compareTo(Shape o) {
        if (this.getClass() != o.getClass()) return this.getClass().getName().compareTo(o.getClass().getName());

        Ellipsis e = (Ellipsis) o;
//        if (this.center.compareTo(e.getCenter()) != 0) return this.center.compareTo(e.getCenter());
        if (this.radiusX != e.getRadiusX()) return this.radiusX - e.getRadiusX();
        if (this.radiusY != e.getRadiusY()) return this.radiusY - e.getRadiusY();

        return this.azimuth.compareTo(e.getAzimuth());
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.rotate(azimuth.getRadian(), center.getX(), center.getY());
        g2d.drawOval(center.getX() - radiusX, center.getY() - radiusY, radiusX * 2, radiusY * 2);
        g2d.rotate(-azimuth.getRadian(), center.getX(), center.getY());

    }

    @Override
    public void applyRotation(Angle angle) {
        if (angle.getDegree() == 0) return;
        this.azimuth = this.azimuth.add(angle);
    }


    @Override
    public void applyTranslation(int deltaX, int deltaY) {
        this.center.applyTranslation(deltaX, deltaY);
    }

    @Override
    public void applyHomothety(float k) {
        this.radiusX *= k;
        this.radiusY *= k;
    }

    public void symetrieaxiale(Axis axis) {
        if (axis == Axis.X) {
            this.center.setY(IMAGE_SIZE - this.center.getY());
        } else {
            this.center.setX(IMAGE_SIZE - this.center.getX());
        }
    }


    @Override
    public void applyCentralSymmetry(Point p) {
        int x1 = p.getX() + (p.getX() - center.getX());
        int y1 = p.getY() + (p.getY() - center.getY());
        this.center.setX(x1);
        this.center.setY(y1);

    }

    @Override
    public String toString() {
        return "Ellipsis{" +
                "center=" + center +
                ", radiusX=" + radiusX +
                ", radiusY=" + radiusY +
                ", azimuth=" + azimuth +
                '}';
    }
}
