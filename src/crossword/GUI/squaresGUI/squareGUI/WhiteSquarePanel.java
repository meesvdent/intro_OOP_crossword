package crossword.GUI.squaresGUI.squareGUI;


import keyboard.GUI.KeyBoardPanel;
import crossword.console.squares.square.WhiteSquare;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Extends AbstractSquarePanel. Panel contains an invisible button which can be clicked to call to a keyboard.
// When a button on the keyboard is clicked the panel will represent the input letter.
public class WhiteSquarePanel extends AbstractSquarePanel {

    JButton button; // button on the panel which can be clicked to trigger a keyboard

    // constructor, adds button to panel
    public WhiteSquarePanel(WhiteSquare whiteSquare){
        super(whiteSquare, Color.WHITE);
        this.getSquarePanel().add(this.createSquareButton(whiteSquare));
    }

    // override of constructor, for extending classes
    public WhiteSquarePanel(WhiteSquare whiteSquare, Color color){
        super(whiteSquare, color);
        this.getSquarePanel().add(this.createSquareButton(whiteSquare));
    }

    // creates JButton with appropriate formatting
    public JButton createSquareButton(WhiteSquare whiteSquare){
        button = new JButton(whiteSquare.getInput());
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.addActionListener(new WhiteSquareEventListener());
        button.setFont(new Font("Arial", Font.PLAIN, 20));
        button.setMargin( new Insets(0, 0, 0, 0) );
        return button;
    }

    // getters and setters
    @Override
    public WhiteSquare getSquare() {
        return (WhiteSquare) this.square;
    }

    public JButton getButton() {
        return this.button;
    }

    // eventlistener, creates keyboard and passes options, underlying square and the pressed button
    public class WhiteSquareEventListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            WhiteSquare curSquare = getSquare();
            KeyBoardPanel keyBoard = new KeyBoardPanel(curSquare.getOptions(), getSquare(), getButton());
            keyBoard.showBoard();
        }
    }

}


