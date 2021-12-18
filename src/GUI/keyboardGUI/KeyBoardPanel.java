package GUI.keyboardGUI;

import GUI.boardGUI.SquareBoardPanel;
import console.Keyboard;
import console.KeyboardKey;
import console.squares.WhiteSquare;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyBoardPanel {

    KeyboardKeyPanel[] keyboardKeyPanels;
    Keyboard keyboard;
    JPanel keyBoardPanel;
    public String choice;
    JFrame keyboardFrame;

    public KeyBoardPanel(Character[] options, WhiteSquare square){
        keyboardKeyPanels = new KeyboardKeyPanel[26];
        keyboard = new Keyboard(options, square);
        KeyboardKey[] keys = keyboard.getKeys();
        KeyboardEventListener keyboardEventListener = new KeyboardEventListener();


        for(int i=0; i<26; i++){
            keyboardKeyPanels[i] = new KeyboardKeyPanel(keys[i], keyboardEventListener);
        }

        JPanel topRowPanel = new JPanel();
        topRowPanel.setLayout(new GridLayout(1, 10));
        topRowPanel.setPreferredSize(new Dimension(10*25, 25));

        JPanel midRowPanel = new JPanel();
        midRowPanel.setLayout(new GridLayout(1, 9));
        midRowPanel.setPreferredSize(new Dimension(9*25, 25));

        JPanel bottomRowPanel = new JPanel();
        bottomRowPanel.setLayout(new GridLayout(1, 7));
        midRowPanel.setPreferredSize(new Dimension(7*25, 25));

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
        this.keyBoardPanel.setLayout(new GridLayout(3, 1));
        this.keyBoardPanel.setPreferredSize(new Dimension(10*25, 3*25));
        this.keyBoardPanel.add(topRowPanel);
        this.keyBoardPanel.add(midRowPanel);
        this.keyBoardPanel.add(bottomRowPanel);
    }

    public void showBoard(){
        keyboardFrame = new JFrame();
        keyboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        keyboardFrame.getContentPane().add(this.keyBoardPanel);
        keyboardFrame.pack();
        keyboardFrame.setVisible(true);
    }

    public static void main(String[] args) {
        Character[] options = {'U', 'D', 'W', 'P', 'Q'};
        WhiteSquare testSquare = new WhiteSquare();
        KeyBoardPanel testKeyBoard = new KeyBoardPanel(options, testSquare);
        testKeyBoard.showBoard();
    }

    public class KeyboardEventListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            keyboard.setChoice(e.getActionCommand());
        }
    }

}
