/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t0m0graf;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

/**
 *
 * @author Ania
 */
public class Sinogram {

    Color[][] pix;//[360][n]

    public Color[][] getPix() {
        return pix;
    }

    public void setPix(Color[][] pix) {
        this.pix = pix;
    }

    /**
     *
     * @param img Obrazek
     * @param B rozwarość stożka
     * @param n liczba detektorow
     */
    public Sinogram(Picture img, int B, int n) {
        int r = (img.getBi().getWidth() / 2)-5;
        BufferedImage bi = img.getBi();
        pix = new Color[360][n];

        //to trzeba dostosowac
        for (int i = 0; i < 360; i++) {
            double help0 = i * Math.PI / 180;
            Double EmiterX = Math.cos(help0) * r + r;
            Double EmiterY = Math.sin(help0) * (-r) + r;
            for (int j = 0; j < n; j++) {
                double help = help0 + Math.PI - (B * Math.PI) / 360 + (B * Math.PI * j) / (180 * (n - 1));
                Double DetektorX = Math.cos(help) * r + r;
                Double DetektorY = Math.sin(help) * (-r) + r;
                //pix[i][j] 
                System.out.println("r " + r + "   help  " + help);
                System.out.println("ex " + EmiterX.intValue() + " ey " + EmiterY.intValue() + " dx " + DetektorX.intValue() + " dy " + DetektorY.intValue());
                pix[i][j]  = BresenhamLine(EmiterX.intValue(), EmiterY.intValue(), DetektorX.intValue(), DetektorY.intValue(), bi);
                //  PixelGrabber pixelGrab = new PixelGrabber(bi, EmiterX.intValue(), EmiterY.intValue(), 1, 1, pix, off, 1);
            }
        }
    }

    // x1 , y1 - współrzędne początku odcinka
    // x2 , y2 - współrzędne końca odcinka
    Color BresenhamLine(int x1, int y1, int x2, int y2, BufferedImage image) {
        // zmienne pomocnicze
        int d, dx, dy, ai, bi, xi, yi;
        int x = x1, y = y1;
        int licznik = 0;
        int suma = 0;
        // ustalenie kierunku rysowania
        if (x1 < x2) {
            xi = 1;
            dx = x2 - x1;
        } else {
            xi = -1;
            dx = x1 - x2;
        }
        // ustalenie kierunku rysowania
        if (y1 < y2) {
            yi = 1;
            dy = y2 - y1;
        } else {
            yi = -1;
            dy = y1 - y2;
        }
        // pierwszy piksel
        //zczytuje kolor piksela 
        /* Color mycolor = new Color(image.getRGB(x, y));
        suma += mycolor.getRed();
        licznik++;
         */
        //   byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        // int      argb = getRGB(x, y);
        // argb = (((int) pixels[3] & 0xff) << 16); // red

        /*
       int[][] data = null ;
image.getData().getPixels(0,0,image.getWidth(),image.getHeight(),data[x]);   
         */
       // System.out.println("x " + x + " y " + y);

        int pixels = image.getRGB(x, y);
        int red = (pixels & 0x00ff0000) >> 16;
        //System.out.println(red);
        suma += red;
       // System.out.println(suma);

        licznik++;

        //image.getRGB(x, y);
        // oś wiodąca OX
        if (dx > dy) {
            ai = (dy - dx) * 2;
            bi = dy * 2;
            d = bi - dx;
            // pętla po kolejnych x
            while (x != x2) {
                // test współczynnika
                if (d >= 0) {
                    x += xi;
                    y += yi;
                    d += ai;
                } else {
                    d += bi;
                    x += xi;
                }

                //Color myc = image.getRaster().getPixel(x,y,doubles);
                //Color collll = new Color(pixels);
                //  pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
                /* argb = getRGB(x, y);
              //  argb = (((int) pixels[3] & 0xff) << 16); // red
                suma += argb;
                    System.out.println(argb);
                 */
              // System.out.println("x " + x + " y " + y);

                pixels = image.getRGB(x, y);
                red = (pixels & 0x00ff0000) >> 16;
              //  System.out.println(red);
                suma += red;
              //  System.out.println(suma);

                licznik++;
            }
        } // oś wiodąca OY
        else {
            ai = (dx - dy) * 2;
            bi = dx * 2;
            d = bi - dy;
            // pętla po kolejnych y
            while (y != y2) {
                // test współczynnika
                if (d >= 0) {
                    x += xi;
                    y += yi;
                    d += ai;
                } else {
                    d += bi;
                    y += yi;
                }
                //Color mycolor2 = new Color(image.getRGB(x, y));
                //suma += mycolor2.getRed();

                //   pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
                /*   argb = getRGB(x, y);
               // argb = (((int) pixels[3] & 0xff) << 16); // red
                suma += argb;
                System.out.println(argb);
                 */
              //  System.out.println("x " + x + " y " + y);
                pixels = image.getRGB(x, y);

                red = (pixels & 0x00ff0000) >> 16;
              //  System.out.println("red" + red);
                suma += red;

              //  System.out.println(suma);

                licznik++;
            }
        }
        int kol = suma / licznik;
        System.out.println("koniec");
        System.out.println(suma);
        System.out.println(licznik);
        System.out.println(kol);
        return new Color(kol, kol, kol);
    }

    private int width;
    private int height;
    private boolean hasAlphaChannel;
    private int pixelLength;
    private byte[] pixels;

    int getRGB(int x, int y) {
        int pos = (y * pixelLength * width) + (x * pixelLength);

        int argb = -16777216; // 255 alpha
        if (hasAlphaChannel) {
            argb = (((int) pixels[pos++] & 0xff) << 24); // alpha
        }

        //  argb += ((int) pixels[pos++] & 0xff); // blue
        // argb += (((int) pixels[pos++] & 0xff) << 8); // green
        argb += (((int) pixels[pos++] & 0xff) << 16); // red
        return argb;
    }
}
