package GUI.boardGUI;

import console.board.QuestionBoard;

import javax.swing.*;

public class QuestionBoardPanel {

    QuestionBoard questionBoard;
    JPanel textPanel;

    public QuestionBoardPanel(String filename){
        this.questionBoard = new QuestionBoard(filename);
        textPanel = new JPanel();

        JTextArea textLabel = new JTextArea(this.questionBoard.toString());
        textPanel.add(textLabel);
    }

    public void showQuestionBoard(){
        JFrame questionFrame = new JFrame("Questions");
        questionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        questionFrame.getContentPane().add(this.textPanel);
        questionFrame.pack();
        questionFrame.setVisible(true);
    }

    public JPanel getQuestionPanel(){
        return this.textPanel;
    }
}
