/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t0m0graf;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static t0m0graf.T0M0GRAF.frame;

/**
 *
 * @author Ania
 */
public class Picture {
    
    public Picture(){
         readIn(getClass().getResourceAsStream("obraz.bmp"));
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
            ImageIcon imgIcon = new ImageIcon(bi);
            label1.setIcon(imgIcon);
        } catch (IOException ex) {
            Logger.getLogger(T0M0GRAF.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
