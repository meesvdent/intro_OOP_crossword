package keyboard.GUI;

import keyboard.console.KeyboardKey;

import javax.swing.*;
import java.awt.*;

public class KeyboardKeyPanel {

    JPanel keyPanel;
    KeyboardKey key;

    public KeyboardKeyPanel(KeyboardKey key, KeyBoardPanel.KeyboardEventListener eventListener){
        this.key = key;

        this.keyPanel = new JPanel();
        this.keyPanel.setLayout(new FlowLayout());
        this.keyPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.keyPanel.setPreferredSize(new Dimension(40, 40));

        if(this.key.isAvailable()){
            this.keyPanel.setBackground(Color.WHITE);
            JButton keyButton = new JButton(String.valueOf(this.key.getLetter()));
            keyButton.setBackground(Color.WHITE);
            keyButton.setOpaque(false);
            keyButton.setBorderPainted(false);
            keyButton.addActionListener(eventListener);
            keyButton.setMargin( new Insets(0, 0, 0, 0) );
            this.keyPanel.add(keyButton);
        } else{
            this.keyPanel.setBackground(Color.GRAY);
        }

    }

    public JPanel getKeyPanel(){
        return this.keyPanel;
    }

}
