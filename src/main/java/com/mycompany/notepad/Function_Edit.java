package com.mycompany.notepad;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;

/**
 *
 * @author ryann
 */

public class Function_Edit {
    GUI gui;
    
    public Function_Edit(GUI gui){
        this.gui = gui;
    }
    
    public void undo(){
        gui.um.undo();
    }
    
    public void redo(){
        gui.um.redo();
    }

    public void cut() {
        String selectedText = gui.textArea.getSelectedText();
        StringSelection selection = new StringSelection(selectedText);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);

        gui.textArea.replaceSelection("");
    }

    public void copy() {
        String selectedText = gui.textArea.getSelectedText();
        StringSelection selection = new StringSelection(selectedText);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);
    }

    public void paste() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        try {
            String clipboardData = (String) clipboard.getData(DataFlavor.stringFlavor);
            gui.textArea.replaceSelection(clipboardData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectAll() {
        gui.textArea.selectAll();
    }
   
}