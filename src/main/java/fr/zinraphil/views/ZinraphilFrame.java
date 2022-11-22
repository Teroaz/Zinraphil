package fr.zinraphil.views;

import fr.zinraphil.models.geometry.Point;
import fr.zinraphil.models.patchwork.Fresco;
import fr.zinraphil.models.patchwork.Image;
import fr.zinraphil.utils.JFrameUtils;

import javax.swing.*;
import java.awt.*;

public class ZinraphilFrame extends JFrame {

    private static int WIDTH;

    private static int HEIGHT;

    public static int IMAGE_SIZE = 200;

    private static ZinraphilFrame instance;

    public ZinraphilFrame() {
        super("Fresco");

//        MenuBar menuBar = new MenuBar();
//        menuBar.add(new Menu("File"));
//        menuBar.add(new Menu("Edit"));
//        this.setMenuBar(menuBar);

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        System.out.println("Resolution retrieved: " + width + "x" + height);

        WIDTH = width - (width % IMAGE_SIZE);
        HEIGHT = height - (height % IMAGE_SIZE);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            this.setResizable(false);
            this.setLayout(null);
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setSize(WIDTH, HEIGHT);

            Point centerFrameCoords = JFrameUtils.centerFrameCoords(WIDTH, HEIGHT);
            this.setLocation(centerFrameCoords.getX(), centerFrameCoords.getY());

            Fresco fresco = new Fresco();
            for (int i = 0; i < WIDTH; i += IMAGE_SIZE) {
                for (int j = 0; j < HEIGHT; j += IMAGE_SIZE) {
                    Image image = new Image(IMAGE_SIZE, IMAGE_SIZE);
                    fresco.addImage(new Point(i, j), image);
                }
            }

            this.setContentPane(new FrescoPanel(fresco));
            this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
