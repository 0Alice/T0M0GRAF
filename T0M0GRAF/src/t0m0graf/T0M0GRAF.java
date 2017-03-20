/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t0m0graf;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Hashtable;
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
import sun.awt.image.WritableRasterNative;

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
    public static JLabel label2 = new JLabel();
    public static JLabel label3 = new JLabel();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // T0M0GRAF tom = new T0M0GRAF();
       UserInterface gui=new UserInterface(1000);
       
       
        Picture picture = new Picture();
        ImageIcon imgIcon = new ImageIcon(picture.getBi());
        label1.setIcon(imgIcon);
        Sinogram sinogram = new Sinogram(picture, 180, 200,1000);
        
        TomographyPicture tomografPic=new TomographyPicture(picture,sinogram);
        //  BufferedImage buffi=new BufferedImage(360, 20, BufferedImage.TYPE_BYTE_GRAY); 
        //raster i dla kazdego piksela zapisywac]

//Hashtable has=new Hashtable();
        //  BufferedImage buffi=new BufferedImage(sinogram.getPix(), sinogram.getPix(), false,has);
        /*
             BufferedImage img = new BufferedImage(picture.getBi().getWidth(), picture.getBi().getHeight(), BufferedImage.TRANSLUCENT);
    Graphics2D graphics = img.createGraphics(); */
        //  Color newColor = new Color(sinogram.getPix(), sinogram.getPix(), sinogram.getPix(), 0 /* alpha needs to be zero */);
        /* graphics.setXORMode(newColor);
    graphics.drawImage(loadImg, null, 0, 0);
    graphics.dispose();
         */
        // buffi.setData((Raster)sinogram.getPix());
      //  ImageIcon imgIcon2 = new ImageIcon(sinogram.getBuf());
       // label2.setIcon(imgIcon2);
        // frame.add(Box.createRigidArea(new Dimension(0, 5)));
        ImageIcon imgIcon3 = new ImageIcon(tomografPic.getBuf());
        label3.setIcon(imgIcon3);

    }

    /**
     * Tworzenie tomografu
     */
    public T0M0GRAF() {
        frame = new JFrame("Tomograf");
        frame.setSize(600, 600);
        // frame.add(label1);
        frame.add(label3);
        frame.setVisible(true);
    }

}
