/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t0m0graf;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ania
 */
public class T0M0GRAF extends JPanel {

    /**
     * Okienko
     */
    public static JFrame frame;
    public static JLabel label1 = new JLabel();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        T0M0GRAF tom = new T0M0GRAF();
        Picture picture = new Picture();
        ImageIcon imgIcon = new ImageIcon(picture.getBi());
        label1.setIcon(imgIcon);
        Sinogram sinogram = new Sinogram(picture, 1 / 2, 20);
        // frame.add(Box.createRigidArea(new Dimension(0, 5)));

    }

    /**
     * Tworzenie tomografu
     */
    public T0M0GRAF() {
        frame = new JFrame("Tomograf");
        frame.setSize(600, 600);

        frame.add(label1);
        frame.setVisible(true);
    }

}
