package GUI.squaresGUI;

import console.squares.AbstractSquare;

import javax.swing.*;
import java.awt.*;

public class AbstractSquarePanel {

    private JPanel squarePanel;
    private AbstractSquare square;

    public AbstractSquarePanel(AbstractSquare abstractSquare, Color color){
        this.square = abstractSquare;
        this.squarePanel = new JPanel();
        this.squarePanel.setLayout(new GridLayout(1, 1));
        this.squarePanel.setBackground(color);
        this.squarePanel.setPreferredSize(new Dimension(25, 25));
        this.squarePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public JPanel getSquarePanel(){
        return this.squarePanel;
    }

    public AbstractSquare getSquare(){
        return this.square;
    }
}