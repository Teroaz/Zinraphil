package fr.zinraphil.controllers;

import fr.zinraphil.models.geometry.Shape;
import fr.zinraphil.views.control.ControlPanel;

public class ControlController {
    private static ControlController instance = null;

    private static ControlPanel controlPanel;

    private static Shape currentShape;

    public ControlController(ControlPanel controlPanel) {
        instance = this;

        ControlController.controlPanel = controlPanel;

    }

    public static ControlController getInstance() {
        if (instance == null) {
            instance = new ControlController(controlPanel);
        }
        return instance;
    }

    public void update() {
        controlPanel.updateUI();
    }
}
