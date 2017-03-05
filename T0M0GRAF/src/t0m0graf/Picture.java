/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t0m0graf;

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

    int off;
    int[] pix;
    int pixX;
    int pixY;
    int r;
    /**
     * Rozwarość stożka
     */
    int B = 1 / 2;
    /**
     * Ile punktów
     */
    int n;

    /*
    Rownanie parametryczne kola 
    
     */
    public Picture() {
        readIn(getClass().getResourceAsStream("obraz.bmp"));
        //jak zadziaal to to 300 trzeba zmienic na szerokosc i wysokosc obrazu

    }

    /**
     * Wczytywanie obrazu
     *
     * @param path stream pliku z obrazem tomografii
     */
    public void readIn(InputStream path) {
        try {
            JLabel label1 = new JLabel();
            frame.add(label1);
            BufferedImage bi;
            bi = ImageIO.read(path);
            r = bi.getWidth();

            ImageIcon imgIcon = new ImageIcon(bi);
            label1.setIcon(imgIcon);

            //to trzeba dostosowac
            for (int i = 0; i < 360; i++) {
                double help0 = i * Math.PI / 180;
                Double EmiterX = Math.cos(help0) * r;
                Double EmiterY = Math.sin(help0) * r;

                for (int j= 0; j < n; j++) {
                    double help = help0 + Math.PI - B / 2 * Math.PI + B * Math.PI * j / (n - 1);
                    double DetektorX = Math.cos(help) * r;
                    double DetektorY = Math.sin(help) * r;

                    for (int k = 0; k < 10; k++) {
                        
                      //  PixelGrabber pixelGrab = new PixelGrabber(bi, EmiterX.intValue(), EmiterY.intValue(), 1, 1, pix, off, 1);
                   
                    }

                }
            }

         

        } catch (IOException ex) {
            Logger.getLogger(T0M0GRAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
