package crossword.GUI.squaresGUI.squareGUI;

import crossword.console.squares.square.BlackSquare;

import java.awt.*;

// Represents a black square, which does not have any other functionality.
public class BlackSquarePanel extends AbstractSquarePanel {

    public BlackSquarePanel(BlackSquare blackSquare){
        super(blackSquare, Color.BLACK);
    }

}
