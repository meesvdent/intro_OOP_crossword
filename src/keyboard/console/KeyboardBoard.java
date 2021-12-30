package keyboard.console;

import crossword.console.squares.square.WhiteSquare;

import java.util.Arrays;
import java.util.List;

public class KeyboardBoard {

    private List<Character> options;
    private final KeyboardKey[] keys;
    private WhiteSquare square;

    public KeyboardBoard(Character[] options, WhiteSquare square){
        this.options = Arrays.asList(options);
        this.square = square;

        char[] alphabet = new char[26];
        for(int i=0; i<26; i++) {
            alphabet[i] = (char) (i + 'A');
        }

        keys = new KeyboardKey[26];
        int k = 0;
        int[] qwertyLayout = {10, 23, 21, 12, 2, 13, 14, 15, 7, 16, 17, 18, 25, 24, 8, 9, 0, 3, 11, 4, 6, 22, 1, 20, 5, 19};
        for(int n : qwertyLayout){
            keys[n] = new KeyboardKey(alphabet[k], (this.options.contains(alphabet[k])));
            k ++;
        }
    }

    public KeyboardKey[] getKeys(){
        return this.keys;
    }

    public void setChoice(String choice){
        this.square.setInput(choice);
    }

    public WhiteSquare getSquare(){
        return this.square;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for(KeyboardKey key : this.keys){
            stringBuilder.append(key.toString());
            if(i == 9 || i == 18){
                stringBuilder.append("\n");
            }
            i++;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Character[] testOptions = {'A', 'B', 'C'};
        WhiteSquare testSquare = new WhiteSquare();
        KeyboardBoard testKeyboardBoard = new KeyboardBoard(testOptions, testSquare);
        System.out.println(testKeyboardBoard);
    }

}
