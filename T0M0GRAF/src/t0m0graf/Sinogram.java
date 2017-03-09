/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t0m0graf;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Ania
 */
public class Sinogram {

    /**
     *
     * @param img Obrazek
     * @param B rozwarość stożka
     * @param n liczba lini (liczba emiterow)
     */
    public Sinogram(Picture img, int B, int n) {
        int r = img.getBi().getWidth() / 2;
        BufferedImage bi = img.getBi();
        Color[][] pix = null;//[360][n]
        //to trzeba dostosowac
        for (int i = 0; i < 360; i++) {
            double help0 = i * Math.PI / 180;
            Double EmiterX = Math.cos(help0) * r;
            Double EmiterY = Math.sin(help0) * r;
            for (int j = 0; j < n; j++) {
                double help = help0 + Math.PI - B / 2 * Math.PI + B * Math.PI * j / (n - 1);
                Double DetektorX = Math.cos(help) * r;
                Double DetektorY = Math.sin(help) * r;
                pix[i][j] = BresenhamLine(EmiterX.intValue(), EmiterY.intValue(), DetektorX.intValue(), DetektorY.intValue(), bi);
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
        Color mycolor = new Color(image.getRGB(x, y));
        suma += mycolor.getRed();
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

                mycolor = new Color(image.getRGB(x, y));
                suma += mycolor.getRed();
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
                mycolor = new Color(image.getRGB(x, y));
                suma += mycolor.getRed();
                licznik++;
            }
        }
        int kol = suma / licznik;
        return new Color(kol, kol, kol);
    }

}
