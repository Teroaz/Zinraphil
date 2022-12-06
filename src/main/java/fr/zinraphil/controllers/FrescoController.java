package fr.zinraphil.controllers;

import fr.zinraphil.views.fresco.FrescoPanel;

public class FrescoController {

    private static FrescoController instance = null;

    private final FrescoPanel frescoPanel;


    public FrescoController(FrescoPanel frescoPanel) {
        instance = this;
        this.frescoPanel = frescoPanel;
    }

    public static FrescoController getInstance() {
        if (instance == null) {
            throw new RuntimeException("FrescoController not initialized");
        }
        return instance;
    }

    public FrescoPanel getFrescoPanel() {
        return frescoPanel;
    }

}
