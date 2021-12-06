package GUI;

import GUI.boardGUI.SquareBoardPanel;

public class Main {
    public static void main(String[] args) {


        String filename = "puzzle-1-adjusted.txt";
        SquareBoardPanel graphicalBoard = new SquareBoardPanel(filename, "southpark");
        graphicalBoard.showBoard();


    }
}
