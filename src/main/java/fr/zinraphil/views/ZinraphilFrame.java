package fr.zinraphil.views;

import fr.zinraphil.controllers.ControlController;
import fr.zinraphil.controllers.FrescoController;
import fr.zinraphil.controllers.ImageController;
import fr.zinraphil.models.geometry.Point;
import fr.zinraphil.models.patchwork.Fresco;
import fr.zinraphil.models.patchwork.Image;
import fr.zinraphil.utils.JFrameUtils;
import fr.zinraphil.views.control.ControlPanel;
import fr.zinraphil.views.fresco.FrescoPanel;

import javax.swing.*;
import java.awt.*;

import static fr.zinraphil.controllers.ZinraphilController.IMAGE_SIZE;

public class ZinraphilFrame extends JFrame {

    private static int WIDTH;

    private static int HEIGHT;

    public ZinraphilFrame() {
        super("Fresco");

        System.out.println("> Instantiating ZinraphilFrame");

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth() - 50;
        int height = gd.getDisplayMode().getHeight() - 50;

        System.out.println("[ZinraphilFrame] Getting screen size: " + width + "x" + height);

        WIDTH = width;
        HEIGHT = height - (height % IMAGE_SIZE);

        System.out.println("[ZinraphilFrame] Setting frame size: " + WIDTH + "x" + HEIGHT);

        try {
            System.out.println("[ZinraphilFrame] Setting look and feel");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            this.setResizable(false);
            this.setLayout(null);
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setUndecorated(true);

            Point centerFrameCoords = JFrameUtils.centerFrameCoords(WIDTH, HEIGHT);
            this.setLocation(centerFrameCoords.getX(), centerFrameCoords.getY());
            System.out.println("[ZinraphilFrame] Placing the frame at middle of the screen: " + centerFrameCoords.getX() + "x" + centerFrameCoords.getY());

            Fresco fresco = new Fresco();
            for (int i = 0; i < HEIGHT; i += IMAGE_SIZE) {
                for (int j = 0; j < HEIGHT; j += IMAGE_SIZE) {
                    Image image = new Image(IMAGE_SIZE, IMAGE_SIZE);
                    fresco.addImage(new Point(i, j), image);
                }
            }

            System.out.println("[ZinraphilFrame] Setting up all the controllers");
            new ImageController();

            FrescoPanel frescoPanel = new FrescoPanel(fresco);
            frescoPanel.setPreferredSize(new Dimension(HEIGHT, HEIGHT));
            new FrescoController(frescoPanel);

            ControlPanel controlPanel = new ControlPanel();
            controlPanel.setPreferredSize(new Dimension(WIDTH - HEIGHT, HEIGHT));
            new ControlController(controlPanel);


            JPanel contentPanePanel = new JPanel();
            contentPanePanel.setSize(WIDTH, HEIGHT);
            contentPanePanel.setLayout(new BorderLayout());
            contentPanePanel.add(frescoPanel, BorderLayout.CENTER);
            contentPanePanel.add(controlPanel, BorderLayout.EAST);

            this.setContentPane(contentPanePanel);

            this.setVisible(true);
            this.pack();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
