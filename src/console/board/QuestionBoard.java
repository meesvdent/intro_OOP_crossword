package console.board;

import console.questions.Question;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionBoard {
    private ArrayList<Question> acrossQuestions;
    private ArrayList<Question> downQuestions;

    public ArrayList<Question> getAcrossQuestions() {
        return acrossQuestions;
    }

    public ArrayList<Question> getDownQuestions() {
        return downQuestions;
    }

    public QuestionBoard(String filename){

        this.acrossQuestions = new ArrayList<>();
        this.downQuestions = new ArrayList<>();

        try(Scanner questionScan = new Scanner(new FileReader(filename))){
            while (questionScan.hasNextLine()){
                String nextLine = questionScan.nextLine();
                Scanner nextScan = new Scanner(nextLine);
                String nextWord = nextScan.next();
                if(nextWord.equals("ACROSS")){
                    nextLine = questionScan.nextLine();
                    nextScan = new Scanner(nextLine);
                    nextWord = nextScan.next();
                    while(! nextWord.equals("DOWN")){
                        this.acrossQuestions.add(new Question(nextLine));
                        nextLine = questionScan.nextLine();
                        nextScan = new Scanner(nextLine);
                        nextWord = nextScan.next();
                    }
                }
                if (nextWord.equals("DOWN")) {
                    while (questionScan.hasNextLine()){
                        this.downQuestions.add(new Question(questionScan.nextLine()));
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Questions:\n");
        output.append("ACROSS\n");
        for (Object question : this.acrossQuestions) {
            output.append(question).append("\n");
        }
        output.append("DOWN\n");
        for (Object question : this.downQuestions) {
            output.append(question).append("\n");
        }
        return output.toString();
    }
}
