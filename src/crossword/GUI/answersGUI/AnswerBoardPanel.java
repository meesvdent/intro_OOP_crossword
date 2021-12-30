package crossword.GUI.answersGUI;

import crossword.GUI.squaresGUI.squareGUI.AnswerSquarePanel;
import crossword.console.answers.AnswerBoard;
import crossword.console.squares.square.AnswerSquare;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnswerBoardPanel {

    JPanel answerPanel;
    AnswerBoard answerBoard;

    public AnswerBoardPanel(String answer){

        this.answerPanel = new JPanel();
        this.answerPanel.setLayout(new FlowLayout());
        this.answerBoard = new AnswerBoard(answer);

        JPanel answerSquareBoard = new JPanel();
        answerSquareBoard.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        for(int i=0; i<answer.length(); i++){
            AnswerSquare curAnswer = answerBoard.getAnswerSquare(i);
            AnswerSquarePanel curPanel = new AnswerSquarePanel(curAnswer);
            answerSquareBoard.add(curPanel.getSquarePanel());
        }

        JButton checkButton = new JButton("Check");
        checkButton.addActionListener(new AnswerBoardEventListener());
        this.answerPanel.add(answerSquareBoard);
        this.answerPanel.add(checkButton);

    }

    // Methods which shows the answerpanel in its own frame, used in testing.
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
            if(answerBoard.checkAnswer()){
                JOptionPane.showMessageDialog(null, "Your answer is correct!");
            } else{
                JOptionPane.showMessageDialog(null, "That's a shame, incorrect!\nKeep trying!");
            }
        }
    }
}
