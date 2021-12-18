package GUI.squaresGUI;


import GUI.boardGUI.SquareBoardPanel;
import GUI.keyboardGUI.KeyBoardPanel;
import console.squares.WhiteSquare;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class WhiteSquarePanel extends AbstractSquarePanel {

    public WhiteSquarePanel(WhiteSquare whiteSquare){
        super(whiteSquare, Color.WHITE);
        JButton button = new JButton();
        button.setBackground(Color.WHITE);
        button.setOpaque(true);
        button.setBorderPainted(false);
        this.getSquarePanel().add(button);
    }

    public WhiteSquarePanel(WhiteSquare whiteSquare, Color color){
        super(whiteSquare, color);
        JButton button = new JButton();
        button.setBackground(color);
        button.setOpaque(true);
        button.setBorderPainted(false);
        this.getSquarePanel().add(button);
    }

}


