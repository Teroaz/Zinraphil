package fr.zinraphil.controllers;

import fr.zinraphil.views.ZinraphilFrame;

public class ZinraphilController {

    public static int IMAGE_SIZE = 250;

    private static ZinraphilController instance = null;

    private ZinraphilFrame zinraphilFrame;

    public ZinraphilController() {
        instance = this;

        zinraphilFrame = new ZinraphilFrame();
    }
}
