package console;

import console.board.Board;

public class Main {
    public static void main(String[] args) {
        String filename = "puzzle-1-adjusted.txt";
        Board testBoard = new Board(filename);
        testBoard.printBoard();
        testBoard.inputSquare(0, 3);
    }
}
