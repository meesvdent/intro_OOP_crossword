package crossword.GUI;

import crossword.GUI.answersGUI.AnswerBoardPanel;
import crossword.GUI.questionsGUI.QuestionBoardPanel;
import crossword.GUI.squaresGUI.SquareBoardPanel;

import javax.swing.*;
import java.awt.*;

// Class which creates the JFrame, adds all classes and runs the program.
public class Puzzle {

    // the three main parts are declared
    SquareBoardPanel squareBoardPanel;
    AnswerBoardPanel answerBoardPanel;
    QuestionBoardPanel questionBoardPanel;

    // Constructor which creates the finale layout
    public Puzzle(String filename, String answer){
        // initiate JFrame
        JFrame crossword = new JFrame("Crossword puzzle");
        crossword.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crossword.setLayout(new FlowLayout());

        // initiate all parts of the crossword
        squareBoardPanel = new SquareBoardPanel(filename);
        answerBoardPanel = new AnswerBoardPanel(answer);
        questionBoardPanel = new QuestionBoardPanel(filename);

        // The layout consist of a panel with flowlayout inside the JFrame
        // On the left side of this panel is the QuestionBoardPanel
        // On the right side is a panel with vertical boxlayout called rightPanel
        // on the top of rightPanel is the squareBoard
        // on the bottom of rightPanel is the answerBoard
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

        // add everything to JFrame
        crossword.getContentPane().add(horizontalPanel);
        crossword.pack();
        crossword.setVisible(true);
    }

    // final main function which runs the code.
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
