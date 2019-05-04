/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnilllosyTorres;

import java.awt.Color;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * Metodo que contiene los anillos que se ultilizaran en las torres
 */
public class Anillos extends JPanel{
    
    /**
     * Constructor de la clase anillos
     */
    
    public Anillos(){
        Random rColoresBase = new Random();
        
        // Colores bases para los anillos
        
        float fRojo =  rColoresBase.nextFloat();
        float fGreen = rColoresBase .nextFloat();
        float fBlue =   rColoresBase.nextFloat();
        
        Color colorAnillo = new Color(fRojo, fGreen, fBlue);
        
        // linea 1
        
         Border bordejpanel = new TitledBorder(new BevelBorder(2));
          
          // linea 2
          
         this.setBorder(bordejpanel); 
        this.setBackground(colorAnillo);
    }
}
