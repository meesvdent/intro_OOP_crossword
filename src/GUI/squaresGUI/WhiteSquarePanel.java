package GUI.squaresGUI;


import GUI.boardGUI.SquareBoardPanel;
import GUI.keyboardGUI.KeyBoardPanel;
import console.squares.AbstractSquare;
import console.squares.WhiteSquare;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class WhiteSquarePanel extends AbstractSquarePanel {

    JButton button;

    public WhiteSquarePanel(WhiteSquare whiteSquare){
        super(whiteSquare, Color.WHITE);
        this.getSquarePanel().add(this.createSquareButton(whiteSquare));
    }

    public WhiteSquarePanel(WhiteSquare whiteSquare, Color color){
        super(whiteSquare, color);
        this.getSquarePanel().add(this.createSquareButton(whiteSquare));
    }

    public JButton createSquareButton(WhiteSquare whiteSquare){
        button = new JButton(whiteSquare.getInput());
        button.setOpaque(false);
        button.setBorderPainted(false);
        button.addActionListener(new WhiteSquareEventListener());
        button.setFont(new Font("Arial", Font.PLAIN, 20));
        return button;
    }

    @Override
    public WhiteSquare getSquare() {
        return (WhiteSquare) this.square;
    }

    public JButton getButton() {
        return this.button;
    }

    public class WhiteSquareEventListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            WhiteSquare curSquare = getSquare();
            KeyBoardPanel keyBoard = new KeyBoardPanel(curSquare.getOptions(), getSquare(), getButton());
            keyBoard.showBoard();
        }
    }

}


