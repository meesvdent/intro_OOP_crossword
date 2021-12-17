package GUI.keyboardGUI;

import console.KeyboardKey;

import javax.swing.*;
import java.awt.*;

public class KeyboardKeyPanel {

    JPanel keyPanel;
    KeyboardKey key;

    public KeyboardKeyPanel(KeyboardKey key){
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
        } else{
            this.keyPanel.setBackground(Color.GRAY);
        }

        this.keyPanel.add(charLabel);
    }

    public JPanel getKeyPanel(){
        return this.keyPanel;
    }
}
