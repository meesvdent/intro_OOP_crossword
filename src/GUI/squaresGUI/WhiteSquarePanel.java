package GUI.squaresGUI;


import console.squares.WhiteSquare;

import java.awt.*;

public class WhiteSquarePanel extends AbstractSquarePanel {

    public WhiteSquarePanel(WhiteSquare whiteSquare){
        super(whiteSquare, Color.WHITE);
    }

    public WhiteSquarePanel(WhiteSquare whiteSquare, Color color){
        super(whiteSquare, color);
    }

}
