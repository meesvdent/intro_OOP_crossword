package GUI.keyboardGUI;

import GUI.boardGUI.QuestionBoardPanel;
import GUI.boardGUI.SquareBoardPanel;
import console.KeyboardKey;
import console.squares.WhiteSquare;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyboardKeyPanel {

    JPanel keyPanel;
    KeyboardKey key;

    public KeyboardKeyPanel(KeyboardKey key, KeyBoardPanel.KeyboardEventListener eventListener){
        this.key = key;

        this.keyPanel = new JPanel();
        this.keyPanel.setLayout(new GridLayout(1, 1));
        this.keyPanel.setPreferredSize(new Dimension(25, 25));
        this.keyPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel charLabel = new JLabel(Character.toString(this.key.getLetter()));
        charLabel.setVerticalAlignment(SwingConstants.CENTER);
        charLabel.setHorizontalAlignment(SwingConstants.CENTER);

        if(this.key.isAvailable()){
            this.keyPanel.setBackground(Color.WHITE);
            JButton keyButton = new JButton(String.valueOf(this.key.getLetter()));
            keyButton.setBackground(Color.WHITE);
            keyButton.setOpaque(true);
            keyButton.setBorderPainted(false);
            keyButton.addActionListener(eventListener);
            this.keyPanel.add(keyButton);
        } else{
            this.keyPanel.setBackground(Color.GRAY);
        }

    }

    public JPanel getKeyPanel(){
        return this.keyPanel;
    }

}
