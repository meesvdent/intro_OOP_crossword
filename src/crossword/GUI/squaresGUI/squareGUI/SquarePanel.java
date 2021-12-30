package crossword.GUI.squaresGUI.squareGUI;

import crossword.console.squares.square.AbstractSquare;

import javax.swing.*;


// Interface, describes the methods which should be implemented by each non abstract SquarePanel.
public interface SquarePanel {

    JPanel getSquarePanel();

    AbstractSquare getSquare();
}
