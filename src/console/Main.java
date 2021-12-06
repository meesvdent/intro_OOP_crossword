package console;

import console.board.AnswerBoard;
import console.board.QuestionBoard;
import console.board.SquareBoard;

public class Main {
    public static void main(String[] args) {
        String filename = "puzzle-1-adjusted.txt";
        SquareBoard testBoard = new SquareBoard(filename);
        System.out.println(testBoard);

        QuestionBoard questionBoard = new QuestionBoard(filename);
        System.out.println(questionBoard);

        AnswerBoard answerBoard = new AnswerBoard("southpark");
        System.out.println(answerBoard);

        testBoard.inputSquare(1, 3);
        answerBoard.inputAnswer(0);
        System.out.println(answerBoard);
    }
}