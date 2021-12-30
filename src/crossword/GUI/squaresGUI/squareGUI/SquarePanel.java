package crossword.GUI.squaresGUI.squareGUI;

import crossword.console.squares.square.AbstractSquare;

import javax.swing.*;

public interface SquarePanel {

    JPanel getSquarePanel();

    AbstractSquare getSquare();
}
