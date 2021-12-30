package console.board;

import console.questions.Question;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class which holds the questions.
 * Receives the filename of the file which holds the puzzle
 * The constructor of this class parses the inputfile and creates a question object for each question in the input file
 */
public class QuestionBoard {

    private ArrayList<Question> acrossQuestions; // array which holds all "across" question objects.
    private ArrayList<Question> downQuestions; // array which holds all "down" question objects.

    public QuestionBoard(String filename){

        this.acrossQuestions = new ArrayList<>(); // initialize question arrays
        this.downQuestions = new ArrayList<>(); // initialize question arrays

        try(Scanner questionScan = new Scanner(new FileReader(filename))){
            // open the puzzle file loop through each line untill the start of the "across" questions is reached.
            while (questionScan.hasNextLine()){
                String nextLine = questionScan.nextLine();
                Scanner nextScan = new Scanner(nextLine);
                String nextWord = nextScan.next();
                if(nextWord.equals("ACROSS")){
                    nextLine = questionScan.nextLine();
                    nextScan = new Scanner(nextLine);
                    nextWord = nextScan.next();
                    while(! nextWord.equals("DOWN")){
                        // create a new Question with the test of a line, it will be parsed by the Question class
                        // add the new question to the "down" array
                        this.acrossQuestions.add(new Question(nextLine));
                        nextLine = questionScan.nextLine();
                        nextScan = new Scanner(nextLine);
                        nextWord = nextScan.next();
                    }
                }
                if (nextWord.equals("DOWN")) {
                    while (questionScan.hasNextLine()){
                        // add down questions to the next line
                        this.downQuestions.add(new Question(questionScan.nextLine()));
                    }
                }

            }
        } catch (FileNotFoundException e) {
            // throw filenotfoundexception if the file is not found.
            e.printStackTrace();
        }
    }

    // getter for across questions
    public ArrayList<Question> getAcrossQuestions() {
        return acrossQuestions;
    }

    // getter for down questions
    public ArrayList<Question> getDownQuestions() {
        return downQuestions;
    }

    // Convert questions to human readable format, used in console version
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
