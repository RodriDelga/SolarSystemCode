/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemasolar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author yared
 */
public class Controlador implements ActionListener, KeyListener{
    
    Marte m;
    public Controlador(Marte m) {
        this.m=m;
    }
    
    public void actionPerfomed(ActionEvent evento){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(""+e.getKeyCode());
        if(e.getKeyCode()==65){
            m.Izquierda();
        }
        if(e.getKeyCode()==68){
            m.Derecha();
        }
        if(e.getKeyCode()==87){
            m.saltar();
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
