package fr.zinraphil.controllers;

import fr.zinraphil.views.ZinraphilFrame;

public class ZinraphilController {

    public static int IMAGE_SIZE = 250;

    private static ZinraphilController instance;

    private final ZinraphilFrame zinraphilFrame;

    public ZinraphilController() {
        instance = this;

        zinraphilFrame = new ZinraphilFrame();
    }

    public ZinraphilFrame getZinraphilFrame() {
        return zinraphilFrame;
    }

    public static ZinraphilController getInstance() {
        return instance;
    }
}
