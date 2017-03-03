/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t0m0graf;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.imageio.ImageIO;
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        frame = new JFrame("Tomograf");
        try {
            T0M0GRAF tomograf = new T0M0GRAF();
        } catch (IOException ex) {
            Logger.getLogger(T0M0GRAF.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.setVisible(true);
    }

    /**
     * Tworzenie tomografu
     *
     * @throws IOException
     */
    public T0M0GRAF() throws IOException {
        readIn(getClass().getResourceAsStream("obraz.bmp"));

    }

    /**
     * Wczytywanie obrazu
     *
     * @param path sciezka do pliku z obrazem tomografii
     */
    public static void readIn(InputStream path) {
        try {
            JLabel label1 = new JLabel();
            frame.add(label1);
            BufferedImage bi;
            bi = ImageIO.read(path);
            ImageIcon imgIcon = new ImageIcon(bi);
            label1.setIcon(imgIcon);
        } catch (IOException ex) {
            Logger.getLogger(T0M0GRAF.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
