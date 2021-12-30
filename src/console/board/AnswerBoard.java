package console.board;

import console.squares.AnswerSquare;

import java.util.Scanner;

/**
 * Class which holds the answer squares. These are the squares where the final answer can be entered.
 * The class will be initialized with a given the correct answer for the crossword.
 * It will create an AnswerSquare for each letter in the answer and place these in a list.
 * It has methods to get and set these answer squares, set answers in the gui version
 * and check whether the input in all AnswerSquares is correct.
 */
public class AnswerBoard {

    private final AnswerSquare[] answerSquares; // array which holds the AnswerSquares, one for each letter in the answer.

    // Constructor for AnswerBoard, parameter is the correct answer.
    public AnswerBoard(String answer){

        this.answerSquares = new AnswerSquare[answer.length()]; // initialize the answerSquare array

        // loop through the characters in the answer, set the corresponding spot in the answersquare array with a new
        // answerSquare which holds the correct character for this position.
        for(int i=0; i<answer.length(); i++){
            char ch = answer.charAt(i);
            answerSquares[i] = new AnswerSquare(ch);
        }

    }

    // getter for answerSquare array
    public AnswerSquare[] getAnswerSquares() {
        return answerSquares;
    }

    // getter for AnswerSquare at specific position
    public AnswerSquare getAnswerSquare(int i){
        return answerSquares[i];
    }


    // input answer at specific position, used in console version
    public void inputAnswer(int i){
        System.out.println("Please enter the desired letter for letter " + i + ": ");
        answerSquares[i].setInput(new Scanner(System.in).next());
    }

    // check the answer for each answer square in the array. Return true only if every input is true
    public boolean checkAnswer(){
        for(AnswerSquare answerSquare : this.answerSquares){
            if(!answerSquare.checkAnswer()){
                return false;
            }
        }
        return true;
    }

    // toString method converts the answerSquares array to human readable format, used in console version.
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append("Current answer: \n");
        for(AnswerSquare square : answerSquares){
            if(square.getInput() == null){
                output.append("_");
            }
            else {
                output.append(square.getInput());
            }
        }
        output.append("\n");
        return output.toString();
    }
}
