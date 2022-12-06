package fr.zinraphil.views.fresco;

import fr.zinraphil.controllers.ControlController;
import fr.zinraphil.controllers.ImageController;
import fr.zinraphil.models.geometry.IDrawable;
import fr.zinraphil.models.geometry.Shape;
import fr.zinraphil.models.patchwork.Image;
import fr.zinraphil.views.control.subcontrol.AbstractSubControlPanel;

import javax.swing.*;
import java.awt.*;

import static fr.zinraphil.controllers.ZinraphilController.IMAGE_SIZE;

public class ImagePanel extends JPanel {

    private final Image image;

    public ImagePanel(Image image) {
        super();
        this.image = image;
        this.setSize(image.getWidth(), image.getHeight());
        this.setBackground(new Color((int) (Math.random() * 0x1000000)));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        image.getShapes().stream().filter(s -> s instanceof IDrawable).forEach(s -> ((IDrawable) s).draw(g));

        drawReperes(g);

        if (this != ImageController.getInstance().getCurrentImagePanel()) {
            this.setBorder(null);
            return;
        }

        g.setColor(Color.RED);
        this.setBorder(BorderFactory.createLineBorder(Color.RED, 5));

        AbstractSubControlPanel subControlPanel = ControlController.getInstance().getControlPanel().getSubControlPanel();
        if (subControlPanel == null) return;

        Shape selectionShape = subControlPanel.getShape();

        g.setColor(Color.LIGHT_GRAY);
        if (selectionShape instanceof IDrawable) {
            ((IDrawable) selectionShape).draw(g);
        }
    }

    private void drawReperes(Graphics g) {
        g.setColor(Color.GRAY);
        g.drawLine(0, IMAGE_SIZE / 2, IMAGE_SIZE, IMAGE_SIZE / 2);
        g.drawLine(IMAGE_SIZE / 2, 0, IMAGE_SIZE / 2, IMAGE_SIZE);
    }

    public Image getImage() {
        return image;
    }
}
