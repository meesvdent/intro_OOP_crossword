package crossword.console;

import crossword.console.answers.AnswerBoard;
import crossword.console.questions.QuestionBoard;
import crossword.console.squares.SquareBoard;

// class used to test console version
public class RunConsole {

    // run test
    public static void runConsole() {
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