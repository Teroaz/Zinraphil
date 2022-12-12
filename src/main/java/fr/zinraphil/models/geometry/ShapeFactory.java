package fr.zinraphil.models.geometry;

import fr.zinraphil.models.geometry.angle.Angle;
import fr.zinraphil.models.geometry.angle.AngleType;

import java.util.ArrayList;
import java.util.Random;

import static fr.zinraphil.controllers.ZinraphilController.IMAGE_SIZE;

public class ShapeFactory {


    public static Shape generateShape(Class shapeClass) {

        if (shapeClass == Circle.class) {
            Random random = new Random();
            int radius = random.nextInt(5, 50);
            return new Circle(new Point(random.nextInt(IMAGE_SIZE - radius), random.nextInt(IMAGE_SIZE - radius)), radius);
        }

        if (shapeClass == Ellipsis.class) {
            Random random = new Random();
            int radius = random.nextInt(5, 50);

            int radiusX = random.nextInt(5, 50);
            int radiusY = random.nextInt(5, 50);

            int azimuth = random.nextInt(0, 360);
            return new Ellipsis(new Point(random.nextInt(IMAGE_SIZE - radius), random.nextInt(IMAGE_SIZE - radius)), radiusX, radiusY, new Angle(AngleType.DEGREE, azimuth));
        }

        if (shapeClass == Line.class) {
            Random random = new Random();
            int x1 = random.nextInt(IMAGE_SIZE);
            int y1 = random.nextInt(IMAGE_SIZE);
            int x2 = random.nextInt(IMAGE_SIZE);
            int y2 = random.nextInt(IMAGE_SIZE);
            return new Line(new Point(x1, y1), new Point(x2, y2));
        }

        if (shapeClass == Polygon.class) {
            Random random = new Random();
            int nbPoints = random.nextInt(3, 10);

            ArrayList<Point> points = new ArrayList<>();

            double angle = 2 * Math.PI / nbPoints;

            for (int i = 0; i < nbPoints; i++) {
                int x = (int) (50 * Math.cos(i * angle));
                int y = (int) (50 * Math.sin(i * angle));
                points.add(new Point(x, y));
            }

            Polygon polygon = new Polygon(points);
            polygon.applyRotation(new Angle(AngleType.DEGREE, random.nextInt(0, 360)));
            polygon.applyTranslation(random.nextInt(IMAGE_SIZE), random.nextInt(IMAGE_SIZE));
            return new Polygon(points);
        }

        return null;
    }
}
