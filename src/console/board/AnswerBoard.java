package console.board;

import console.squares.AnswerSquare;

import java.util.Scanner;

public class AnswerBoard {

    private final AnswerSquare[] answerSquares;

    public AnswerBoard(String answer){

        char[] charArray = answer.toCharArray();
        AnswerSquare[] answerSquares = new AnswerSquare[answer.length()];

        for(int i=0; i<answer.length(); i++){
            char ch = answer.charAt(i);
            answerSquares[i] = new AnswerSquare(ch);
        }

        this.answerSquares = answerSquares;
    }

    public AnswerSquare[] getAnswerSquares() {
        return answerSquares;
    }

    public AnswerSquare getAnswerSquare(int i){
        return answerSquares[i];
    }

    public void inputAnswer(int i){
        answerSquares[i].setInput(new Scanner(System.in).next());
    }

    public boolean checkAnswer(){
        for(AnswerSquare answerSquare : this.answerSquares){
            if(!answerSquare.checkAnswer()){
                return false;
            }
        }
        return true;
    }
}
