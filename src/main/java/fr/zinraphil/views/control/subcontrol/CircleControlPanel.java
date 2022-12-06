package fr.zinraphil.views.control.subcontrol;

import fr.zinraphil.models.geometry.Circle;
import fr.zinraphil.models.geometry.Point;

import javax.swing.*;
import java.awt.*;

public class CircleControlPanel extends AbstractSubControlPanel<Circle> {

    JLabel clickLabel;
    JLabel coordLabel;

    public CircleControlPanel() {
        super("Panneau de controle du cercle");

        this.shape = new Circle(new Point(0, 0), 5);

        setLayout(new BorderLayout());

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        JPanel centerPanel = new JPanel();

        centerPanel.setLayout(new GridBagLayout());

        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        clickLabel = new JLabel("Cliquez sur l'image pour dessiner un cercle");
        clickLabel.setFont(clickLabel.getFont().deriveFont(20f));
        centerPanel.add(clickLabel, c);

        c.gridy++;
        coordLabel = new JLabel("Coordonnees du centre : (%d, %d)".formatted(shape.getCenter().getX(), shape.getCenter().getY()));
        coordLabel.setFont(coordLabel.getFont().deriveFont(20f));
        centerPanel.add(coordLabel, c);

        JLabel rayonTextFieldLabel = new JLabel("Rayon : ");
        JTextField rayonTextField = new JTextField("%d".formatted(shape.getRadius()));
        rayonTextField.addKeyListener(
                new java.awt.event.KeyAdapter() {
                    public void keyReleased(java.awt.event.KeyEvent evt) {
                        try {
                            shape.setRadius(Integer.parseInt(rayonTextField.getText()));
                        } catch (NumberFormatException e) {
                            shape.setRadius(0);
                        }
                    }
                }
        );
        rayonTextField.setPreferredSize(new Dimension(100, 20));

        JPanel rayonPanel = new JPanel();
        rayonPanel.add(rayonTextFieldLabel);
        rayonPanel.add(rayonTextField);

        c.gridy++;
        centerPanel.add(rayonPanel, c);

        this.add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    public void onMouseMove(int x, int y) {
        shape.getCenter().setX(x);
        shape.getCenter().setY(y);

        coordLabel.setText("Coordonnees du centre : (%d, %d)".formatted(shape.getCenter().getX(), shape.getCenter().getY()));

    }

    @Override
    public void onMouseClick(int x, int y) {
        shape.getCenter().setX(x);
        shape.getCenter().setY(y);

        System.out.println("Cercle cree : " + shape.toString());
        this.addShape(shape);

        coordLabel.setText("Coordonnées du centre : (%d, %d)".formatted(shape.getCenter().getX(), shape.getCenter().getY()));
    }
}
