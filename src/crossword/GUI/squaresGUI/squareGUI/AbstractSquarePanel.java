package crossword.GUI.squaresGUI.squareGUI;

import crossword.GUI.squaresGUI.SquareBoardPanel;
import crossword.console.squares.square.AbstractSquare;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractSquarePanel implements SquarePanel {

    private JPanel squarePanel;
    protected AbstractSquare square;

    public AbstractSquarePanel(AbstractSquare abstractSquare, Color color){
        this.square = abstractSquare;
        this.squarePanel = new JPanel();
        this.squarePanel.setLayout(new FlowLayout());
        this.squarePanel.setPreferredSize(new Dimension(40, 40));
        this.squarePanel.setBackground(color);
        this.squarePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public JPanel getSquarePanel(){
        return this.squarePanel;
    }

    public AbstractSquare getSquare(){
        return this.square;
    }
}
