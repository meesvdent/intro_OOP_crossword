package GUI;

import GUI.boardGUI.AnswerBoardPanel;
import GUI.boardGUI.QuestionBoardPanel;
import GUI.boardGUI.SquareBoardPanel;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame crossword = new JFrame("Crossword puzzle");
        crossword.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crossword.setLayout(new FlowLayout());

        JPanel crosswordPanel = new JPanel();
        crosswordPanel.setLayout(new FlowLayout());

        String filename = "puzzle-1-adjusted.txt";

        SquareBoardPanel squareBoardPanel = new SquareBoardPanel(filename, "southpark");
        AnswerBoardPanel answerBoardPanel = new AnswerBoardPanel("SOUTHPARK");
        QuestionBoardPanel questionBoardPanel = new QuestionBoardPanel(filename);


        crosswordPanel.setPreferredSize(new Dimension(700, 700));
        crosswordPanel.add(questionBoardPanel.getQuestionPanel());
        crosswordPanel.add(squareBoardPanel.getBoardPanel());
        crosswordPanel.add(answerBoardPanel.getAnswerPanel());

        crossword.getContentPane().add(crosswordPanel);
        crossword.pack();
        crossword.setVisible(true);
    }
}
