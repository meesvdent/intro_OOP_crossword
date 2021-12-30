package crossword.GUI.squaresGUI.squareGUI;

import crossword.console.squares.square.GreySquare;

import java.awt.*;

// Extends WhiteSquarePanel. Same behavior as WhiteSquarePanel, except represented as grey.
public class GreySquarePanel extends WhiteSquarePanel{

    public GreySquarePanel(GreySquare greySquare){
        super(greySquare, Color.GRAY);
    }

}
