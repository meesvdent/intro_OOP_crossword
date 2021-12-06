package GUI.squaresGUI;

import GUI.squaresGUI.WhiteSquarePanel;
import console.squares.AnswerSquare;

import java.awt.*;

public class AnswerSquarePanel extends WhiteSquarePanel {

    public AnswerSquarePanel(AnswerSquare answerSquare){
        super(answerSquare, Color.GRAY);
    }
}
