package crossword.GUI;

import crossword.GUI.answersGUI.AnswerBoardPanel;
import crossword.GUI.questionsGUI.QuestionBoardPanel;
import crossword.GUI.squaresGUI.SquareBoardPanel;

import javax.swing.*;
import java.awt.*;

public class Puzzle {

    SquareBoardPanel squareBoardPanel;
    AnswerBoardPanel answerBoardPanel;
    QuestionBoardPanel questionBoardPanel;

    public Puzzle(String filename, String answer){
        JFrame crossword = new JFrame("Crossword puzzle");
        crossword.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crossword.setLayout(new FlowLayout());

        squareBoardPanel = new SquareBoardPanel(filename);
        answerBoardPanel = new AnswerBoardPanel(answer);
        questionBoardPanel = new QuestionBoardPanel(filename);

        JPanel horizontalPanel = new JPanel();
        horizontalPanel.setLayout(new FlowLayout());

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        JPanel rightLowerPanel = new JPanel();

        horizontalPanel.add(questionBoardPanel.getQuestionPanel());
        rightPanel.add(squareBoardPanel.getBoardPanel());
        rightPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        rightPanel.add(rightLowerPanel);
        JPanel answerBoardPanelJPanel = answerBoardPanel.getAnswerPanel();
        answerBoardPanelJPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        rightLowerPanel.add(answerBoardPanelJPanel);
        horizontalPanel.add(rightPanel);

        crossword.getContentPane().add(horizontalPanel);
        crossword.pack();
        crossword.setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        Puzzle runPuzzle = new Puzzle("src/puzzle-1-adjusted.txt", "SOUTHPARK");
                    }
                }
        );
    }
}
