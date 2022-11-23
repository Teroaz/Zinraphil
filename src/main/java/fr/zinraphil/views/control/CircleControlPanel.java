package fr.zinraphil.views.control;

import javax.swing.*;

public class CircleControlPanel extends JPanel {

    public CircleControlPanel() {
        super();

        JLabel label = new JLabel("Panneau de cercle");
        label.setFont(label.getFont().deriveFont(60f));
        this.add(label);
    }
}
