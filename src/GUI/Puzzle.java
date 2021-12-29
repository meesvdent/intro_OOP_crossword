package GUI;

import GUI.boardGUI.AnswerBoardPanel;
import GUI.boardGUI.QuestionBoardPanel;
import GUI.boardGUI.SquareBoardPanel;
import GUI.keyboardGUI.KeyBoardPanel;

import javax.swing.*;
import java.awt.*;

public class Puzzle {

    JFrame crosswordFrame;

    SquareBoardPanel squareBoardPanel;
    AnswerBoardPanel answerBoardPanel;
    QuestionBoardPanel questionBoardPanel;

    KeyBoardPanel keyBoardPanel;

    public Puzzle(String filename, String answer){
        JFrame crossword = new JFrame("Crossword puzzle");
        crossword.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crossword.setLayout(new FlowLayout());

        squareBoardPanel = new SquareBoardPanel(filename, answer);
        answerBoardPanel = new AnswerBoardPanel(answer);
        questionBoardPanel = new QuestionBoardPanel(filename);

        JPanel horizontalPanel = new JPanel();
        horizontalPanel.setLayout(new FlowLayout());

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        horizontalPanel.add(questionBoardPanel.getQuestionPanel());
        rightPanel.add(squareBoardPanel.getBoardPanel());
        rightPanel.add(answerBoardPanel.getAnswerPanel());
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
                        Puzzle runPuzzle = new Puzzle("puzzle-1-adjusted.txt", "SOUTHPARK");
                    }
                }
        );

    }
}
