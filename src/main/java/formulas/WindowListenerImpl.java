package formulas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.awt.image.BufferedImage;

public class WindowListenerImpl implements WindowStateListener {

    Dimension dimension;
    JLabel imageLabel;
    Image dimg;
    BufferedImage image;

    public WindowListenerImpl(BufferedImage image, Image img, JLabel label, Dimension dimension) {
        this.imageLabel = label;
        this.dimension = dimension;
        this.dimg = img;
        this.image = image;
    }


    @Override
    public void windowStateChanged(WindowEvent e) {
        if ((e.getNewState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH) {
            dimg = image.getScaledInstance(image.getWidth(), image.getHeight(),
                    Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(dimg));
            e.getWindow().revalidate();
        } else if ((e.getNewState() & Frame.NORMAL) == Frame.NORMAL) {
            dimg = image.getScaledInstance(image.getWidth() * 2 / 3, image.getHeight() * 2 / 3,
                    Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(dimg));
            e.getWindow().revalidate();
        }

    }
}
