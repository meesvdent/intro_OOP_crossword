package GUI.boardGUI;

import GUI.squaresGUI.AnswerSquarePanel;
import console.board.AnswerBoard;
import console.squares.AnswerSquare;

import javax.swing.*;
import java.awt.*;

public class AnswerBoardPanel {

    JPanel answerPanel;
    AnswerBoard answerBoard;

    public AnswerBoardPanel(String answer){

        this.answerPanel = new JPanel();
        this.answerPanel.setLayout(new FlowLayout());
        this.answerPanel.setPreferredSize(new Dimension(answer.length()*25+100, 35));
        this.answerBoard = new AnswerBoard(answer);
        JPanel answerSquarePanel = new JPanel();
        answerSquarePanel.setLayout(new GridLayout(1, answer.length()));
        answerSquarePanel.setPreferredSize(new Dimension(answer.length()*25, 25));
        for(int i=0; i<answer.length(); i++){
            AnswerSquare curAnswer = answerBoard.getAnswerSquare(i);
            AnswerSquarePanel curPanel = new AnswerSquarePanel(curAnswer);
            answerSquarePanel.add(curPanel.getSquarePanel());
        }

        this.answerPanel.add(answerSquarePanel);
        JButton checkButton = new JButton("Check!");
        this.answerPanel.add(checkButton);

    }

    public void showAnswerPanel(){
        JFrame answerFrame = new JFrame("Answer");
        answerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        answerFrame.getContentPane().add(this.answerPanel);
        answerFrame.pack();
        answerFrame.setVisible(true);
    }

    public JPanel getAnswerPanel(){
        return this.answerPanel;
    }


}
