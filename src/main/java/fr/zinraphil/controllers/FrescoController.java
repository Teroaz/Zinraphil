package fr.zinraphil.controllers;

import fr.zinraphil.views.fresco.FrescoPanel;

public class FrescoController {

    private static FrescoController instance = null;

    private static FrescoPanel frescoPanel;


    public FrescoController(FrescoPanel frescoPanel) {
        instance = this;
        FrescoController.frescoPanel = frescoPanel;
    }

    public static FrescoController getInstance() {
        if (instance == null) {
            throw new RuntimeException("FrescoController not initialized");
        }
        return instance;
    }

    public static FrescoPanel getFrescoPanel() {
        return frescoPanel;
    }

}
