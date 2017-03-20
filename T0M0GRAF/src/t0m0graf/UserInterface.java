/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t0m0graf;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Ania
 */
public class UserInterface {
    
    
    //ilosc emiterow
    //il detektorow
    //kat
    
    public UserInterface(double emiter){
        Pane pane=new AnchorPane();
        Scene scene = new Scene(pane, 700, 700);
        
        
        
    Slider slider = new Slider();
    slider.setOrientation(Orientation.HORIZONTAL);
    slider.setMax(emiter);
    slider.setMin(0);
    slider.valueProperty().addListener((observable,oldvalue,newvalue) -> { int i=newvalue.intValue();});
    
    
    
    
    
    
            } 
}
