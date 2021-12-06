package console.board;

import console.questions.Question;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionBoard {
    private ArrayList<Question>[] questions;

    public QuestionBoard(String filename){

        this.questions = new ArrayList[2];

        try(Scanner questionScan = new Scanner(new FileReader(filename))){
            while (questionScan.hasNextLine()){
                String nextLine = questionScan.nextLine();
                Scanner nextScan = new Scanner(nextLine);
                String nextWord = nextScan.next();
                if(nextWord.equals("ACROSS")){
                    this.questions[0] = new ArrayList<>();
                    nextLine = questionScan.nextLine();
                    nextScan = new Scanner(nextLine);
                    nextWord = nextScan.next();
                    while(! nextWord.equals("DOWN")){
                        this.questions[0].add(new Question(nextLine));
                        nextLine = questionScan.nextLine();
                        nextScan = new Scanner(nextLine);
                        nextWord = nextScan.next();
                    }
                }
                if (nextWord.equals("DOWN")) {
                    this.questions[1] = new ArrayList<>();
                    while (questionScan.hasNextLine()){
                        this.questions[1].add(new Question(questionScan.nextLine()));
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
        for (Object question : this.questions[0]) {
            output.append(question).append("\n");
        }
        output.append("DOWN\n");
        for (Object question : this.questions[1]) {
            output.append(question).append("\n");
        }
        return output.toString();
    }
}
