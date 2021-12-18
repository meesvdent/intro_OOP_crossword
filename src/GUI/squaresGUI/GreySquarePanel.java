package GUI.squaresGUI;

import GUI.boardGUI.SquareBoardPanel;
import console.squares.GreySquare;

import java.awt.*;

public class GreySquarePanel extends WhiteSquarePanel{

    public GreySquarePanel(GreySquare greySquare){
        super(greySquare, Color.GRAY);
    }

}
