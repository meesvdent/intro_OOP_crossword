package crossword.GUI.squaresGUI.squareGUI;

import crossword.console.squares.square.AnswerSquare;

import java.awt.*;

// Extends WhiteSquarePanel.
// Same functionality as WhiteSquarePanel, except with grey background.
// Will only be used in the AnswerBoardPanel.
public class AnswerSquarePanel extends WhiteSquarePanel {

    public AnswerSquarePanel(AnswerSquare answerSquare){
        super(answerSquare, Color.GRAY);
    }
}
