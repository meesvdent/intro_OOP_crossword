package keyboard.GUI;

import keyboard.console.KeyboardBoard;
import keyboard.console.KeyboardKey;
import crossword.console.squares.square.WhiteSquare;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyBoardPanel {

    KeyboardKeyPanel[] keyboardKeyPanels;
    KeyboardBoard keyboardBoard;
    JPanel keyBoardPanel;
    JFrame keyboardFrame;
    JButton sourceButton;

    public KeyBoardPanel(Character[] options, WhiteSquare square, JButton button){
        keyboardKeyPanels = new KeyboardKeyPanel[26];
        keyboardBoard = new KeyboardBoard(options, square);
        KeyboardKey[] keys = keyboardBoard.getKeys();
        KeyboardEventListener keyboardEventListener = new KeyboardEventListener();
        sourceButton = button;

        for(int i=0; i<26; i++){
            keyboardKeyPanels[i] = new KeyboardKeyPanel(keys[i], keyboardEventListener);
        }

        JPanel topRowPanel = new JPanel();
        topRowPanel.setLayout(new FlowLayout());

        JPanel midRowPanel = new JPanel();
        midRowPanel.setLayout(new FlowLayout());

        JPanel bottomRowPanel = new JPanel();
        bottomRowPanel.setLayout(new FlowLayout());

        for(int i=0; i<26; i++){
            if(i < 10){
                topRowPanel.add(keyboardKeyPanels[i].getKeyPanel());
            }
            if(i >= 10 && i < 19){
                midRowPanel.add(keyboardKeyPanels[i].getKeyPanel());
            }
            if(i >= 19){
                bottomRowPanel.add(keyboardKeyPanels[i].getKeyPanel());
            }
        }

        this.keyBoardPanel = new JPanel();
        this.keyBoardPanel.setLayout(new BoxLayout(keyBoardPanel, BoxLayout.Y_AXIS));
        this.keyBoardPanel.add(topRowPanel);
        this.keyBoardPanel.add(midRowPanel);
        this.keyBoardPanel.add(bottomRowPanel);
    }

    public void showBoard(){
        keyboardFrame = new JFrame();
        keyboardFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        keyboardFrame.getContentPane().add(this.keyBoardPanel);
        keyboardFrame.pack();
        keyboardFrame.setVisible(true);
    }

    public static void main(String[] args) {
        Character[] options = {'U', 'D', 'W', 'P', 'Q'};
        WhiteSquare testSquare = new WhiteSquare();
        JButton testButton = new JButton("Test");
        KeyBoardPanel testKeyBoard = new KeyBoardPanel(options, testSquare, testButton);
        testKeyBoard.showBoard();
    }

    public class KeyboardEventListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            keyboardBoard.setChoice(e.getActionCommand());
            sourceButton.setText(keyboardBoard.getSquare().getInput());
            sourceButton.setMargin(new Insets(0, 0, 0, 0));
            keyboardFrame.dispose();
        }
    }
}
