package fr.zinraphil;

import fr.zinraphil.models.geometry.Ellipsis;
import fr.zinraphil.models.geometry.IRotation;
import fr.zinraphil.models.geometry.Line;
import fr.zinraphil.models.geometry.Point;
import fr.zinraphil.models.geometry.angle.Angle;
import fr.zinraphil.views.ZinraphilFrame;

import static fr.zinraphil.models.geometry.angle.AngleType.DEGREE;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        new ZinraphilFrame();

        IRotation objetQuiAUneRotation = new Line(new Point(0, 0), new Point(1, 1));
        objetQuiAUneRotation.rotation(new Angle(DEGREE, 45));
        

    }
}
