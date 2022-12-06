package fr.zinraphil.controllers;

import fr.zinraphil.views.control.ControlPanel;

public class ControlController {
    private static ControlController instance = null;

    private final ControlPanel controlPanel;


    public ControlController(ControlPanel controlPanel) {
        instance = this;

        this.controlPanel = controlPanel;

    }

    public static ControlController getInstance() {
        if (instance == null) {
            throw new RuntimeException("ControlController not initialized");
        }
        return instance;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

}

