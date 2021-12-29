package GUI.boardGUI;

import GUI.squaresGUI.AnswerSquarePanel;
import console.board.AnswerBoard;
import console.squares.AnswerSquare;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnswerBoardPanel {

    JPanel answerPanel;
    AnswerBoard answerBoard;

    public AnswerBoardPanel(String answer){

        AnswerBoardEventListener eventListener = new AnswerBoardEventListener();

        this.answerPanel = new JPanel();
        this.answerPanel.setLayout(new FlowLayout());
        this.answerBoard = new AnswerBoard(answer);
        for(int i=0; i<answer.length(); i++){
            AnswerSquare curAnswer = answerBoard.getAnswerSquare(i);
            AnswerSquarePanel curPanel = new AnswerSquarePanel(curAnswer);
            this.answerPanel.add(curPanel.getSquarePanel());
        }

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

    public class AnswerBoardEventListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){

        }
    }


}
