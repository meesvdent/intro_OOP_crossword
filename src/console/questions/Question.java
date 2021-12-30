package console.questions;

import java.util.Scanner;

// Class which holds a question.
// Holds both the question and a string containing the numbering.
// Also determines and holds whether a question should be represented in a bold font, in this case if the question
// starts with an integer followed by a comma.
public class Question {

    private final String numberString; // string which contains the numbering before a question
    private final String question; // question string which holds the actual questions
    private boolean bold; // boolean, if true the question should be represented in bold.

    // constructor, receives an unparsed question string.
    public Question(String unparsedQuestion){
        // split string on first space, part before is numbering, after is question
        String[] questionParts = unparsedQuestion.split(" ", 2);
        this.numberString = questionParts[0];
        this.question = questionParts[1];
        // use checkbold function to set bold variable
        if(this.checkBold()){
            this.bold = true;
        }
    }

    // checkbold function. In this case returns true if the questions starts with an integer followed by a comma.
    public boolean checkBold(){
        // split on first comma
        String firstWord = this.question.split(",", 2)[0];
        // initialize scanner to scan for in
        Scanner numberScan = new Scanner(firstWord);
        // if there is a number in the first word, return true, otherwise false.
        return numberScan.hasNextInt();
    }

    // represent questions in human readable format, used in console version
    public String toString(){
        return this.numberString + " " + this.question;
    }

    // getters for number and question strings
    public String getNumberString(){
        return this.numberString;
    }

    public String getQuestion() {
        return question;
    }

    // getter for isbold boolean.
    public boolean isBold() {
        return bold;
    }
}
