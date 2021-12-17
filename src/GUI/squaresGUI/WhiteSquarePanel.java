package GUI.squaresGUI;


import GUI.keyboardGUI.KeyBoardPanel;
import console.squares.WhiteSquare;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WhiteSquarePanel extends AbstractSquarePanel {

    public WhiteSquarePanel(WhiteSquare whiteSquare){
        super(whiteSquare, Color.WHITE);
        JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WhiteSquare square = (WhiteSquare) getSquare();
                Character[] options = square.getOptions();
                KeyBoardPanel optionKeyboard = new KeyBoardPanel(options);
                                         optionKeyboard.showBoard();
                                     }
                                 }
        );
        button.setBackground(Color.WHITE);
        button.setOpaque(true);
        button.setBorderPainted(false);
        this.getSquarePanel().add(button);
    }

    public WhiteSquarePanel(WhiteSquare whiteSquare, Color color){
        super(whiteSquare, color);
        JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("colored square");
                WhiteSquare square = (WhiteSquare) getSquare();
                System.out.println("casted");
                Character[] options = square.getOptions();
                System.out.println(options);
                KeyBoardPanel optionKeyboard = new KeyBoardPanel(options);
                optionKeyboard.showBoard();
            }
        }
        );
        button.setBackground(color);
        button.setOpaque(true);
        button.setBorderPainted(false);
        this.getSquarePanel().add(button);
    }

}
