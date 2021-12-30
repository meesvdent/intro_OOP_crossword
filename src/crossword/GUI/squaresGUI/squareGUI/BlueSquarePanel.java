package crossword.GUI.squaresGUI.squareGUI;

import crossword.console.squares.square.BlueSquare;
import java.awt.*;

// Extends WhiteSquarePanel. Same behavior as WhiteSquarePanel, except when the button is clicked, the keyboard will
// have less available letters, determined by the options variable of the BlueSquare which is a member variable of this class.
public class BlueSquarePanel extends WhiteSquarePanel{

    public BlueSquarePanel(BlueSquare blueSquare){
        super(blueSquare, new Color(51, 153, 255));
    }

}
