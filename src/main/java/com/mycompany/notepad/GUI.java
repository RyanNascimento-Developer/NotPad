package com.mycompany.notepad;

//Importes necessarios
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

/**
 *
 * @author ryann
 */

public class GUI implements ActionListener{
    
    //Iniciando a tela com o nome (window)
    JFrame window;
    
    //Text Area
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrapOn = false;
    
    //Top menu bar
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;
    
    //File menu
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
    
    //Edit menu
    JMenuItem iUndo, iRedo, iCut, iCopy, iPaste, iSelectAll;
    
    //Format menu
    JMenu menuFont, menuFontSize;
    JMenuItem iWrap, iFontArial, iFontCSMS, iFontTNR, iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28;
    
    //color menu
    JMenuItem iColor1, iColor2, iColor3;

    //Sobre menu
    JMenu menuAjuda;
    JMenuItem iAjuda;

    //Chamando as funções das outras class
    Function_File file = new Function_File(this);
    Function_Format format = new Function_Format(this);
    Function_Color color = new Function_Color(this);
    Function_Edit edit = new Function_Edit(this);

    UndoManager um = new UndoManager();
    
    //Chamando a função do atalho para os botões
    KeyHandler kHandler = new KeyHandler(this);
    
    public static void main(String[] args){    
        new GUI();            
   }
    
   public GUI(){
     
     //Chamada dos metodos
     createWindow();
     createTextArea();
     createMenuBar();
     createFileMenu();
     createEditMenu();
     createFormatMenu();
     createColorMenu();
     createAjudaMenu();
          
     //Formatação padrão da fonte
     format.selectedFont = "Arial";
     format.crateFont(16);
     format.wordWrap();
    
     //Formatação padrão da cor
     color.changeColor("White");

     window.setVisible(true);
   }
   
   public void createWindow(){   
    window = new JFrame("NotePad");
    window.setSize(800,600);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
   }  
   
   public void createTextArea(){
    textArea = new JTextArea();
    textArea.setFont(format.arial);
    
    textArea.addKeyListener(kHandler);

    textArea.getDocument().addUndoableEditListener(
            new UndoableEditListener(){
                public void undoableEditHappened(UndoableEditEvent e){
                    um.addEdit(e.getEdit());
                }
            }
    );
    
    scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setBorder(BorderFactory.createEmptyBorder());
    
    window.add(scrollPane);
   }
   
    
   public void createMenuBar(){
    menuBar = new JMenuBar();
    window.setJMenuBar(menuBar);

    menuFile = new JMenu("Arquivo");
    menuBar.add(menuFile);

    menuEdit = new JMenu("Editar");
    menuBar.add(menuEdit);

    menuFormat = new JMenu("Format");
    menuBar.add(menuFormat);

    menuColor = new JMenu("Color");
    menuBar.add(menuColor);
    
    menuAjuda = new JMenu("Ajuda");
    menuBar.add(menuAjuda);
   }
   
   public void createFileMenu(){
    iNew = new JMenuItem("New");
    iNew.addActionListener(this);
    iNew.setActionCommand("New");
    menuFile.add(iNew);
    
    iOpen = new JMenuItem("Open");
    iOpen.addActionListener(this);
    iOpen.setActionCommand("Open");
    menuFile.add(iOpen);
    
    iSave = new JMenuItem("Save");
    iSave.addActionListener(this);
    iSave.setActionCommand("Save");
    menuFile.add(iSave);
    
    iSaveAs = new JMenuItem("Save As");
    iSaveAs.addActionListener(this);
    iSaveAs.setActionCommand("SaveAs");
    menuFile.add(iSaveAs);
    
    iExit = new JMenuItem("Exit");
    iExit.addActionListener(this);
    iExit.setActionCommand("Exit");
    menuFile.add(iExit);   
   }
   
   public void createFormatMenu(){
       iWrap = new JMenuItem("Word Wrap: off");
       iWrap.addActionListener(this);
       iWrap.setActionCommand("Word Wrap");
       menuFormat.add(iWrap);
       
       //formatação da fonte da letra
       menuFont = new JMenu("Font");
       menuFormat.add(menuFont);
       
       iFontArial = new JMenuItem("Arial");
       iFontArial.addActionListener(this);
       iFontArial.setActionCommand("Arial");
       menuFont.add(iFontArial);
       
       iFontCSMS = new JMenuItem("Comic Sans MS");
       iFontCSMS.addActionListener(this);
       iFontCSMS.setActionCommand("Comic Sans MS");
       menuFont.add(iFontCSMS);
       
       iFontTNR = new JMenuItem("Times New Roman");
       iFontTNR.addActionListener(this);
       iFontTNR.setActionCommand("Times New Roman");
       menuFont.add(iFontTNR);
       
       //Formatação do tmanho da letra
       menuFontSize = new JMenu("Font Size");
       menuFormat.add(menuFontSize);
       
       iFontSize8 = new JMenuItem("8");
       iFontSize8.addActionListener(this);
       iFontSize8.setActionCommand("Size8");
       menuFontSize.add(iFontSize8);
       
       iFontSize12 = new JMenuItem("12");
       iFontSize12.addActionListener(this);
       iFontSize12.setActionCommand("Size12");
       menuFontSize.add(iFontSize12);
       
       iFontSize16 = new JMenuItem("16");
       iFontSize16.addActionListener(this);
       iFontSize16.setActionCommand("Size16");
       menuFontSize.add(iFontSize16);
       
       iFontSize20 = new JMenuItem("20");
       iFontSize20.addActionListener(this);
       iFontSize20.setActionCommand("Size20");
       menuFontSize.add(iFontSize20);
       
       iFontSize24 = new JMenuItem("24");
       iFontSize24.addActionListener(this);
       iFontSize24.setActionCommand("Size24");
       menuFontSize.add(iFontSize24);
       
       iFontSize28 = new JMenuItem("28");
       iFontSize28.addActionListener(this);
       iFontSize28.setActionCommand("Size28");
       menuFontSize.add(iFontSize28);
   }
   
   public void createEditMenu(){
       //Desfazer
       iUndo = new JMenuItem("Undo");
       iUndo.addActionListener(this);
       iUndo.setActionCommand("Undo");
       menuEdit.add(iUndo);
       
       //Refazer
       iRedo = new JMenuItem("Redo");
       iRedo.addActionListener(this);
       iRedo.setActionCommand("Redo");
       menuEdit.add(iRedo);
       
       iCut = new JMenuItem("Recortar");
       iCut.addActionListener(this);
       iCut.setActionCommand("Cut");
       menuEdit.add(iCut);

       iCopy = new JMenuItem("Copiar");
       iCopy.addActionListener(this);
       iCopy.setActionCommand("Copy");
       menuEdit.add(iCopy);

       iPaste = new JMenuItem("Colar");
       iPaste.addActionListener(this);
       iPaste.setActionCommand("Paste");
       menuEdit.add(iPaste);

       iSelectAll = new JMenuItem("Selecionar Tudo");
       iSelectAll.addActionListener(this);
       iSelectAll.setActionCommand("SelectAll");
       menuEdit.add(iSelectAll);
   }
   
   public void createColorMenu(){
       iColor1 = new JMenuItem("White");
       iColor1.addActionListener(this);
       iColor1.setActionCommand("White");
       menuColor.add(iColor1);
       
       iColor2 = new JMenuItem("Black");
       iColor2.addActionListener(this);
       iColor2.setActionCommand("Black");
       menuColor.add(iColor2);
       
       iColor3 = new JMenuItem("Blue");
       iColor3.addActionListener(this);
       iColor3.setActionCommand("Blue");
       menuColor.add(iColor3);
              
   }
   
       public void createAjudaMenu(){
       iAjuda = new JMenuItem("Sobre");
       iAjuda.addActionListener(this);
       iAjuda.setActionCommand("Ajuda");
       menuAjuda.add(iAjuda);    
       
   }

   
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
          
        switch(command){
            
            //Menu arquivo
            case "New": file.newFile();
            break;
            
            case "Open": file.open();
            break;            
            
            case "Save": file.save();
            break;
            
            case "SaveAs": file.saveAs();
            break;
            
            case "Exit": file.exit();
            break;
            
            
            //Menu Edit
            case "Undo": edit.undo();
            break;
            
            case "Redo": edit.redo();
            break;         
           
            case "Cut": edit.cut();
            break;

            case "Copy": edit.copy();
            break;

            case "Paste": edit.paste(); 
            break;

            case "SelectAll": edit.selectAll();
            break;
            
            
            //Se é texto continuo ou pula linha
            case "Word Wrap": format.wordWrap();
            break;
            
            
            //Formatação da letra
            case "Arial": format.setFont(command);
            break;
            
            case "Comic Sans MS": format.setFont(command);
            break;
            
            case "Times New Roman": format.setFont(command);
            break;
            
            
            //Tamanho da letra
            case "Size8": format.crateFont(8);
            break;
            
            case "Size12": format.crateFont(12);
            break;
            
            case "Size16": format.crateFont(16);
            break;
            
            case "Size20": format.crateFont(20);
            break;
            
            case "Size24": format.crateFont(24);
            break;
            
            case "Size28": format.crateFont(28);
            break;
            
            
            //Cores
            case "White": color.changeColor(command);
            break;
            
            case "Black": color.changeColor(command);
            break;
            
            case "Blue": color.changeColor(command);
            break;
            
            
            //Sobre o desenvolvedor
            case "Ajuda":
            Function_Ajuda Function_Ajuda = new Function_Ajuda();
            break;
                        
        }        
    }

    private void setIcon(Image image) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}