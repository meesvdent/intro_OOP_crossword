package GUI.squaresGUI;

import GUI.boardGUI.SquareBoardPanel;
import console.squares.BlueSquare;

import java.awt.*;

public class BlueSquarePanel extends WhiteSquarePanel{

    public BlueSquarePanel(BlueSquare blueSquare){
        super(blueSquare, new Color(51, 153, 255));
    }

}
