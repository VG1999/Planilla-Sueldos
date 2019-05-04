/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnilllosyTorres;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * Clase que represente la torre en el juego de Hanoi
 * 
 */


public class Torres extends JPanel{
    
    /**
     * Constructor clase Torres
     */
    
    public Torres(){
             this.setLayout(null);
    }
    
    /**
     * Metodo para el dibujo de la torre en el panel
     * @param g
     */
    
    @Override
    public void  paintComponent(Graphics g){
        
        super.paintComponent(g);
       this.setBackground(Color.WHITE);
        
        g.setColor(Color.BLACK);
        
        // base de la torre
        g.fillRect(10, 270, 200,5);
        
        // asta de la torre
          g.fillRect(110, 30, 5, 240);
        
           }
}
