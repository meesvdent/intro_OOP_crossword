package crossword.GUI.questionsGUI;

import crossword.console.questions.QuestionBoard;
import crossword.console.questions.Question;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.util.ArrayList;

public class QuestionBoardPanel {

    QuestionBoard questionBoard;
    JPanel textPanel;

    public QuestionBoardPanel(String filename) {
        this.questionBoard = new QuestionBoard(filename);
        textPanel = new JPanel();

        JTextPane pane = new JTextPane();
        pane.setEditable(false);
        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setForeground(set, new Color(102, 0, 153));
        StyleConstants.setBold(set, true);
        Document doc = pane.getStyledDocument();

        try {
            doc.insertString(doc.getLength(), "Crossword puzzle instructions:\n\nACROSS\n", set);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        StyleConstants.setBold(set, false);
        doc = this.addQuestionsToDoc(doc, this.questionBoard.getAcrossQuestions(), Color.BLACK, new Color(102, 0, 153));
        StyleConstants.setBold(set, true);

        try {
            doc.insertString(doc.getLength(), "\nDOWN\n", set);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        StyleConstants.setBold(set, false);
        this.addQuestionsToDoc(doc, this.questionBoard.getDownQuestions(), Color.BLACK, new Color(102, 0, 153));

        textPanel.add(pane);
    }

    public Document addQuestionsToDoc(Document doc, ArrayList<Question> questions, Color questionColor, Color numberColor){
        SimpleAttributeSet set = new SimpleAttributeSet();
        for(Question question : questions){
            StyleConstants.setForeground(set, numberColor);
            StyleConstants.setBold(set, true);
            try {
                doc.insertString(doc.getLength(), question.getNumberString() + " ", set);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
            StyleConstants.setForeground(set, questionColor);
            StyleConstants.setBold(set, question.isBold());
            try{
                doc.insertString(doc.getLength(), question.getQuestion() + "\n", set);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
            StyleConstants.setBold(set,false);
        }
        return doc;
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
