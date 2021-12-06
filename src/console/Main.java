package console;

import console.board.SquareBoard;

public class Main {
    public static void main(String[] args) {
        String filename = "puzzle-1-adjusted.txt";
        SquareBoard testBoard = new SquareBoard(filename, "southpark");
        System.out.println(testBoard);
        testBoard.inputSquare(0, 3);
    }
}