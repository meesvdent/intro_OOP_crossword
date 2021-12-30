package crossword.GUI.questionsGUI;

import crossword.console.questions.QuestionBoard;
import crossword.console.questions.Question;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.util.ArrayList;

// Graphical version of the QuestionBoard.
// It receives the input file location in its constructor and creates a new QuestionBoard instance.
// It will add all Questions to a JTextPane, both the question number and the question itself in their appropriate formatting.
public class QuestionBoardPanel {

    QuestionBoard questionBoard; // variable which holds underlying questionboard
    JPanel textPanel; // textpanel which holds questions

    // constructor
    public QuestionBoardPanel(String filename) {
        // create questionboard which parses the file
        this.questionBoard = new QuestionBoard(filename);
        textPanel = new JPanel();

        // setup pane and doc
        JTextPane pane = new JTextPane();
        pane.setEditable(false);
        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setForeground(set, new Color(102, 0, 153));
        StyleConstants.setBold(set, true);
        Document doc = pane.getStyledDocument();

        // add static content to pane
        try {
            doc.insertString(doc.getLength(), "Crossword puzzle instructions:\n\nACROSS\n", set);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        // set correct font
        StyleConstants.setBold(set, false);
        doc = this.addQuestionsToDoc(doc, this.questionBoard.getAcrossQuestions(), Color.BLACK, new Color(102, 0, 153));
        StyleConstants.setBold(set, true);

        // add static formatting
        try {
            doc.insertString(doc.getLength(), "\nDOWN\n", set);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        StyleConstants.setBold(set, false);

        // function loops through down questions and add them to pane
        this.addQuestionsToDoc(doc, this.questionBoard.getDownQuestions(), Color.BLACK, new Color(102, 0, 153));

        // add pane to panel
        textPanel.add(pane);
    }

    // function loops through an arraylist of questions
    // add numbers in purple and questions in black
    // adds bold questions in bold
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

    // function for testing
    public void showQuestionBoard(){
        JFrame questionFrame = new JFrame("Questions");
        questionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        questionFrame.getContentPane().add(this.textPanel);
        questionFrame.pack();
        questionFrame.setVisible(true);
    }

    // getter
    public JPanel getQuestionPanel(){
        return this.textPanel;
    }
}
