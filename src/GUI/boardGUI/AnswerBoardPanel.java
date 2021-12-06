package GUI.boardGUI;

import GUI.squaresGUI.AnswerSquarePanel;
import console.board.AnswerBoard;
import console.squares.AnswerSquare;

import javax.swing.*;

public class AnswerBoardPanel {

    JPanel answerPanel;
    AnswerBoard answerBoard;

    public AnswerBoardPanel(String answer){
        this.answerBoard = new AnswerBoard(answer);
        for(int i=0; i<answer.length(); i++){
            AnswerSquare curAnswer = answerBoard.getAnswerSquare(i);
            AnswerSquarePanel curPanel = new AnswerSquarePanel(curAnswer);
            answerPanel.add(curPanel.getSquarePanel());
        }
    }

    public void showAnswerPanel(){
        JFrame answerFrame = new JFrame("Answer");
        answerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        answerFrame.getContentPane().add(this.answerPanel);
        answerFrame.pack();
        answerFrame.setVisible(true);
    }


}
