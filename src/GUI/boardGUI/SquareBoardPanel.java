package GUI.boardGUI;

import GUI.keyboardGUI.KeyBoardPanel;
import GUI.squaresGUI.AbstractSquarePanel;
import GUI.squaresGUI.BlackSquarePanel;
import GUI.squaresGUI.BlueSquarePanel;
import GUI.squaresGUI.GreySquarePanel;
import GUI.squaresGUI.WhiteSquarePanel;
import console.board.SquareBoard;
import console.squares.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SquareBoardPanel {

    JPanel boardPanel;
    AbstractSquarePanel[][] squarePanels;
    SquareBoardEventListener eventListener;

    public SquareBoardPanel(String filename, String answer) {
        SquareBoard squareBoard = new SquareBoard(filename);
        AbstractSquare[][] abstractSquares = squareBoard.getSquares();

        AbstractSquarePanel[][] squarePanels = new AbstractSquarePanel[squareBoard.getHeight()][squareBoard.getWidth()];
        for (int i = 0; i < abstractSquares.length; i++) {
            for (int j = 0; j < abstractSquares[i].length; j++) {
                if (abstractSquares[i][j].getType().equals("white")) {
                    squarePanels[i][j] = new WhiteSquarePanel((WhiteSquare) abstractSquares[i][j]);
                }
                if (abstractSquares[i][j].getType().equals("grey")) {
                    squarePanels[i][j] = new GreySquarePanel((GreySquare) abstractSquares[i][j]);
                }
                if (abstractSquares[i][j].getType().equals("black")) {
                    squarePanels[i][j] = new BlackSquarePanel((BlackSquare) abstractSquares[i][j]);
                }
                if (abstractSquares[i][j].getType().equals("blue")) {
                    squarePanels[i][j] = new BlueSquarePanel((BlueSquare) abstractSquares[i][j]);
                }
            }

        }

        this.boardPanel = new JPanel();
        this.boardPanel.setLayout(new GridLayout(squareBoard.getHeight(), squareBoard.getWidth()));

        JPanel topRow = new JPanel();
        topRow.setLayout(new FlowLayout());
        for (AbstractSquarePanel[] squarePanel : squarePanels) {
            for (AbstractSquarePanel abstractSquarePanel : squarePanel) {
                boardPanel.add(abstractSquarePanel.getSquarePanel());
            }
        }
    }

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


    public class SquareBoardEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("clicked squareboard");
        }

    }
}
