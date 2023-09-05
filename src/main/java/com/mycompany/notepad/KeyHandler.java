package com.mycompany.notepad;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 *
 * @author ryann
 */
    
public class KeyHandler implements KeyListener{

    GUI gui;
    
    public KeyHandler(GUI gui){
        this.gui = gui;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //Salvar
        if(e.isControlDown()&& e.getKeyCode() == KeyEvent.VK_S){
            gui.file.save();
        }
        
        //Salvar Como
        if(e.isControlDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_S){
            gui.file.saveAs();
        }
        
        //Atalho para o menu Ajuda
        if(e.isAltDown() && e.getKeyCode() == KeyEvent.VK_F){
            gui.menuAjuda.doClick();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
}