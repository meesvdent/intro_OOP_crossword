package crossword.GUI.squaresGUI;

import crossword.GUI.squaresGUI.squareGUI.AbstractSquarePanel;
import crossword.GUI.squaresGUI.squareGUI.BlackSquarePanel;
import crossword.GUI.squaresGUI.squareGUI.BlueSquarePanel;
import crossword.GUI.squaresGUI.squareGUI.GreySquarePanel;
import crossword.GUI.squaresGUI.squareGUI.WhiteSquarePanel;
import crossword.console.squares.SquareBoard;
import crossword.console.squares.square.*;
import enums.SquareType;

import javax.swing.*;
import java.awt.*;

// Class which represents the graphical version of the SquareBoard.
// Receives the input file location as a variable in its constructor and creates a new SquareBoard instance.
// It will create a new AbstractSquarePanel instance of the appropriate type for each AbstractSquare in the SquareBoard.
// These will be added to a JFrame.
public class SquareBoardPanel {

    JPanel boardPanel; // Panel on which the class is represented

    // constructor, creates the boardPanel
    public SquareBoardPanel(String filename) {

        // initiate squareBoard and array for squared
        SquareBoard squareBoard = new SquareBoard(filename);
        AbstractSquare[][] abstractSquares = squareBoard.getSquares();

        // loop through squares in squareboard, create panels and add to 2d array representing the board
        AbstractSquarePanel[][] squarePanels = new AbstractSquarePanel[squareBoard.getHeight()][squareBoard.getWidth()];
        for (int i = 0; i < abstractSquares.length; i++) {
            for (int j = 0; j < abstractSquares[i].length; j++) {
                if (abstractSquares[i][j].getType().equals(SquareType.WHITE)) {
                    squarePanels[i][j] = new WhiteSquarePanel((WhiteSquare) abstractSquares[i][j]);
                }
                if (abstractSquares[i][j].getType().equals(SquareType.GREY)) {
                    squarePanels[i][j] = new GreySquarePanel((GreySquare) abstractSquares[i][j]);
                }
                if (abstractSquares[i][j].getType().equals(SquareType.BLACK)) {
                    squarePanels[i][j] = new BlackSquarePanel((BlackSquare) abstractSquares[i][j]);
                }
                if (abstractSquares[i][j].getType().equals(SquareType.BLUE)) {
                    squarePanels[i][j] = new BlueSquarePanel((BlueSquare) abstractSquares[i][j]);
                }
            }

        }

        // initiate panel with grid layout
        this.boardPanel = new JPanel();
        this.boardPanel.setLayout(new GridLayout(squareBoard.getHeight(), squareBoard.getWidth()));

        // loop through panels in 2d array and add to boardPanel
        JPanel topRow = new JPanel();
        topRow.setLayout(new FlowLayout());
        for (AbstractSquarePanel[] squarePanel : squarePanels) {
            for (AbstractSquarePanel abstractSquarePanel : squarePanel) {
                    boardPanel.add(abstractSquarePanel.getSquarePanel());
            }
        }
    }

    // Functions which shows the squareboard in its own frame, used in testing.
    public void showBoard() {
        JFrame boardFrame = new JFrame();
        boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boardFrame.getContentPane().add(this.boardPanel);
        boardFrame.pack();
        boardFrame.setVisible(true);
    }

    public JPanel getBoardPanel() {
        return this.boardPanel;
    }

}
