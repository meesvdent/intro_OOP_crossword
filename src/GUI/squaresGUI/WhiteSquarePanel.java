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
        button = new JButton(whiteSquare.getInput());
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.addActionListener(new WhiteSquareEventListener());
        button.setMargin( new Insets(0, 0, 0, 0) );
        this.getSquarePanel().add(button);
    }

    public WhiteSquarePanel(WhiteSquare whiteSquare, Color color){
        super(whiteSquare, color);
        button = new JButton(whiteSquare.getInput());
        button.setText(whiteSquare.getInput());
        button.setOpaque(false);
        button.setBorderPainted(false);
        button.addActionListener(new WhiteSquareEventListener());
        button.setMargin( new Insets(0, 0, 0, 0));
        this.getSquarePanel().add(button);
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
            WhiteSquare curSquare = (WhiteSquare) getSquare();
            KeyBoardPanel keyBoard = new KeyBoardPanel(curSquare.getOptions(), getSquare(), getButton());
            keyBoard.showBoard();
        }
    }

}


