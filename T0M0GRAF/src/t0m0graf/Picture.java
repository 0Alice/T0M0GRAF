/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t0m0graf;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static t0m0graf.T0M0GRAF.frame;
import java.awt.image.PixelGrabber;

/**
 *
 * @author Ania
 */
public class Picture {

    BufferedImage bi;

    public Picture() {
        readIn(getClass().getResourceAsStream("obraz.bmp"));
        //tu trzeba zmienic na choosera
    }

    /**
     * Wczytywanie obrazu
     *
     * @param path stream pliku z obrazem tomografii
     */
    public void readIn(InputStream path) {
        try {
            bi = ImageIO.read(path);
        } catch (IOException ex) {
            Logger.getLogger(T0M0GRAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BufferedImage getBi() {
        return bi;
    }

    public void setBi(BufferedImage bi) {
        this.bi = bi;
    }

}
