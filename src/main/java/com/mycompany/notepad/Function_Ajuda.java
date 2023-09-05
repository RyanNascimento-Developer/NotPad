package com.mycompany.notepad;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.AbstractBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;

/**
 *
 * @author ryann
 */

public class Function_Ajuda extends JFrame {
    
    public Function_Ajuda() {
    
        setTitle("R2 Desenvolvimento");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 350);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(new RoundedBorder(Color.BLACK, 2, 10)); // Adiciona uma borda com cantos arredondados ao painel

        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true); // Habilita a quebra automática de linha
        textArea.setWrapStyleWord(true); // Quebra as palavras inteiras
        textArea.setText("Desenvolvido por: Ryan Nascimento\n\n"
                + "O Notepad é uma ferramenta simples de edição de texto\n"
                + "que serve para várias tarefas básicas, como fazer anotações, editar códigos\n"
                + "simples, visualizar e editar arquivos de texto, remover formatação e muito mais.\n\n"
                + "Sua simplicidade e disponibilidade tornam-no uma opção prática para várias situações do dia a dia.");

        JScrollPane scrollPane = new JScrollPane(textArea); // Adiciona uma barra de rolagem ao JTextArea

        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);

        setLocationRelativeTo(null); // Centraliza a janela na tela
        setVisible(true);
    }
    
    private class RoundedBorder extends AbstractBorder {
        private Color color;
        private int thickness;
        private int radius;

        public RoundedBorder(Color color, int thickness, int radius) {
            this.color = color;
            this.thickness = thickness;
            this.radius = radius;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.setColor(color);
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(thickness, thickness, thickness, thickness);
        }

        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = insets.top = insets.right = insets.bottom = thickness;
            return insets;
        }

        public boolean isBorderOpaque() {
            return true;
        }
    }
        
}