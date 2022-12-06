package fr.zinraphil.views.control;

import javax.swing.*;

public class EllipsisControlPanel extends JPanel {

    public EllipsisControlPanel() {
        super();

        JLabel label = new JLabel("Panneau d'ellipse");
        label.setFont(label.getFont().deriveFont(40f));
        this.add(label);
    }
}
