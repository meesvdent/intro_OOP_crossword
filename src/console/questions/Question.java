package console.questions;

import java.util.Scanner;

public class Question {

    private String numberString;
    private String question;
    private boolean bold;

    public Question(String unparsedQuestion){
        String[] questionParts = unparsedQuestion.split(" ", 2);
        this.numberString = questionParts[0];
        this.question = questionParts[1];
        if(this.checkBold()){
            this.bold = true;
        }
    }

    public boolean checkBold(){
        String firstWord = this.question.split(",", 2)[0];
        Scanner numberScan = new Scanner(firstWord);
        return numberScan.hasNextInt();
    }

    public String toString(){
        return this.numberString + " " + this.question;
    }

    public String getNumberString(){
        return this.numberString;
    }

    public String getQuestion() {
        return question;
    }

    public boolean isBold() {
        return bold;
    }
}
